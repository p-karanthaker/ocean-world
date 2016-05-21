package uk.ac.aston.dc2300.ocean.world;

import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import uk.ac.aston.dc2300.ocean.life.Creature;
import uk.ac.aston.dc2300.ocean.life.Plankton;
import uk.ac.aston.dc2300.ocean.life.Sardine;
import uk.ac.aston.dc2300.ocean.life.Shark;
import uk.ac.aston.dc2300.ocean.life.Species;

public class Simulator {

	private static Simulator instance = null;
	
	private static Field field;
	private static SimulatorView view;
	
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

	    Simulator.getInstance().init(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);; //Create and show the GUI.
		Simulator.getInstance().startSimulation();
	}
	
	private Simulator() {
		
	}
	
	public static Simulator getInstance() {
		if(instance == null) {
			return new Simulator();
		}
		return instance;
	}
	
	public void init(int width, int depth) {
		field = new Field(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);

		view = new SimulatorView(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);
		view.setColor(Plankton.class, Color.GREEN);
		view.setColor(Sardine.class, Color.DARK_GRAY);
		view.setColor(Shark.class, Color.CYAN);
		view.setJMenuBar(MenuView.createMenuBar(view));
	}
	
	public void populate() {
        //Holds the value of the specides chosen randomly
        Species decicedCreature;
        RandomGenerator.initialiseWithSeed(ModelConstants.RNG_SEED);
        Random rand = RandomGenerator.getRandom();
		field.clear();
	            
	            
        //Cycle through all locations in the field
        for(int depth = 0; depth < field.getDepth(); depth++) {
            for(int width = 0; width < field.getWidth(); width++) {
                //Use a random number generator to decide what creature to create
                decicedCreature = creationDecider(rand.nextDouble());
                
                //Create the creature and place in field
                field.place(CreatureFactory.getCreature(decicedCreature), new Location(depth, width));
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
	
	public void startSimulation() {
		populate();
        simulate();
		view.showStatus(0, field);
	}
        
    private void simulate(){
        simulateOneStep();
    }
    
    private void simulateOneStep(){
        for(int depth = 0; depth < field.getDepth(); depth++) {
            for(int width = 0; width < field.getWidth(); width++) {
                Creature currentCreature = null;
                currentCreature = field.getObjectAt(depth, width);
                
                if(currentCreature != null) {
                    //Check the species to see if it can move
                    if(canMove(currentCreature)) {

                        Location newLocation = null;
                        newLocation = field.freeAdjacentLocation(new Location(depth, width));

                        if(newLocation != null) {
                            //Set new location
                            currentCreature.setLocation(newLocation);

                            //Move to new creature
                            field.place(currentCreature, newLocation);
                        }
                    }
                }
            }
        }
    }   
    
    private boolean canMove(Creature creature) {
        switch(creature.getSpecies()) {
            case SHARK:
            case SARDINE:
                return true;
            case PLANKTON:
            default:
                return false;
        }
    }
        
	
}