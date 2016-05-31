package uk.ac.aston.dc2300.ocean.world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import uk.ac.aston.dc2300.ocean.gui.MenuView;
import uk.ac.aston.dc2300.ocean.gui.SimulatorView;
import uk.ac.aston.dc2300.ocean.life.Creature;
import uk.ac.aston.dc2300.ocean.life.CreatureFactory;
import uk.ac.aston.dc2300.ocean.life.Plankton;
import uk.ac.aston.dc2300.ocean.life.Sardine;
import uk.ac.aston.dc2300.ocean.life.Shark;
import uk.ac.aston.dc2300.ocean.life.Species;

/**
 * The Simulator application controller.
 * 
 * @author Karan Thaker / Orry Edwards
 *
 */
public class Simulator {
	
	/**
	 * The field used for the simulation.
	 */
	private Field field;
	
	/**
	 * Displays and updates the field
	 */
	private SimulatorView view;
	
	/**
	 * A list to hold all creatures which are alive
	 */
	private List<Creature> creatures;
	
	/**
	 * The current simulation step
	 */
	private int simulationStep = 0;
	
	/**
	 * Random object used for selection with probabilities and preventing observed behaviour
	 */
	private Random random;
	
	/**
	 * Application entry point.
	 * 
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
	    try {
	        // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
	    
	    
	    Simulator sim = new Simulator(ModelConstants.OCEAN_DEPTH, ModelConstants.OCEAN_WIDTH);
	    sim.initialise();
	    sim.simulate(ModelConstants.SIMULATION_LENGTH);
	}
	
	/**
	 * Constructor for the Simulator. Initialised various fields,
	 * sets the colours of the animals, and adds a JMenuBar to the view.
	 * 
	 * @param depth the depth of the simulation field
	 * @param width the width of the simulation field
	 */
	public Simulator(int depth, int width) {
		RandomGenerator.initialiseWithSeed(ModelConstants.RNG_SEED);
		random = RandomGenerator.getRandom();
		
		creatures = new ArrayList<Creature>();
		
		field = new Field(depth, width);
		view = new SimulatorView(depth, width);
		
		view.setColor(Plankton.class, Color.GREEN);
		view.setColor(Sardine.class, Color.DARK_GRAY);
		view.setColor(Shark.class, Color.CYAN);
		view.setJMenuBar(MenuView.createMenuBar(view));
	}
	
	/**
	 * Populates the field with creatures randomly based on their
	 * creation probability.
	 */
	public void populate() {
        // Holds the value of the species chosen randomly
        Species decicedCreature;
        field.clear();

        // Cycle through all locations in the field
        for(int depth = 0; depth < field.getDepth(); depth++) {
            for(int width = 0; width < field.getWidth(); width++) { 
            	// Use a random number generator to decide what creature to create
                decicedCreature = creationDecider(random.nextDouble());

                // Create the creature 
                Creature newCreature = null;
                newCreature = CreatureFactory.getCreature(decicedCreature, false, new Location(depth, width));
                
                // and place in field
                if(newCreature != null) {       
                    field.place(newCreature, newCreature.getLocation());
                    creatures.add(newCreature);
                }
            }
        }
	}
        
    /**
     * Using cumulative probability, decide on the type of creature
     * to place in the Field.
     * P(A) = 0.1, P(B) = 0.4
     * Event A occurs if the random number < P(A)
     * Event B occurs if the random number < P(A) + P(B)
     * and so on...
     * 
     * @param randomNumber
     * @return the chosen species of creature
     */
    private Species creationDecider(double randomNumber) {
    	// Store creature types in hashmap with their probabilities
    	HashMap<Species, Double> probs = new HashMap<Species, Double>();
    	probs.put(Species.PLANKTON, ModelConstants.CREATION_ODDS_PLANKTON);
    	probs.put(Species.SARDINE, ModelConstants.CREATION_ODDS_SARDINE);
    	probs.put(Species.SHARK, ModelConstants.CREATION_ODDS_SHARK);
    	
    	double subtotal = 0;
    	/* Loops over the hashmap and checks if the random number is 
    	 * less than the cumulative probability. */
    	for(Species species : probs.keySet()) {
    		subtotal += probs.get(species);
    		if (randomNumber < subtotal) {
    			return species;
    		}
    	}
    	return Species.EMPTY;
    }
	
    /**
     * Initialises the Simulation for a new usage
     */
    public void initialise() {
    	simulationStep = 0;
		creatures.clear();
		field.clear();
		populate();
		view.showStatus(simulationStep, field);
    }
       
    /**
     * Simulates the ocean field and all activity for the pre-defined number of steps
     */
    public void simulate(int simulationLength) {
        while(simulationStep <= simulationLength && view.isViable(field))
        {
            simulateOneStep();
            view.showStatus(simulationStep, field);
            simulationStep++;
        }
    }
    
    /**
     * Handles the movement of all the creatures per step in the simulation
     */
    private void simulateOneStep(){
    	// Shuffle creatures to prevent observed behaviour
        Collections.shuffle(creatures, random);
        
        /*
         * Use a ListIterator rather than iterating over the list itself so that
         * we can add and remove objects from it whilst iterating. This prevents
         * a ConcurentModificationException.
         */
        for(ListIterator<Creature> listIterator = creatures.listIterator(); listIterator.hasNext();){
        	Creature creature = listIterator.next();
        	if (creature.isAlive()) {
        		if (creature.getAge() < creature.getMaxAge()) {
	        		creature.act(field);
	        		Creature baby = creature.breed(field);
	        		if(baby != null) {
	        			listIterator.add(baby);
	        		}
        		} else {
        			creature.setNotAlive();
        			field.place(null, creature.getLocation());
        		}
        	} else if (!creature.isAlive()) {
        		// Remove dead creatures for memory efficiency
        		listIterator.remove();
        	}
        }
    }
}