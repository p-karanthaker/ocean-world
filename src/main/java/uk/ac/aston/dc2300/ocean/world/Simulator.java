package uk.ac.aston.dc2300.ocean.world;

import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

import uk.ac.aston.dc2300.ocean.life.Plankton;
import uk.ac.aston.dc2300.ocean.life.Sardine;
import uk.ac.aston.dc2300.ocean.life.Shark;
import uk.ac.aston.dc2300.ocean.life.Species;

public class Simulator {

	private static Field field;
	private static SimulatorView view;
	
	public static void main(String[] args) {
		Simulator sim = new Simulator(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);
		
		sim.startSimulation();
	}
	
	public Simulator(int width, int depth) {
		field = new Field(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);

		view = new SimulatorView(50, 50);
		view.setColor(Plankton.class, Color.GREEN);
		view.setColor(Sardine.class, Color.DARK_GRAY);
		view.setColor(Shark.class, Color.CYAN);
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
                decicedCreature = creationDecider(rand.nextFloat());
                
                //Create the creature and place in field
                field.place(CreatureFactory.getCreature(decicedCreature), new Location(depth, width));
            }
        }
	}
        
    //Decides what type of creature needs to be created
    private Species creationDecider(float randomNumber) {
    	HashMap<Species, Float> probs = new HashMap<Species, Float>();
    	probs.put(Species.PLANKTON, ModelConstants.CREATION_ODDS_PLANKTON);
    	probs.put(Species.SARDINE, ModelConstants.CREATION_ODDS_SARDINE);
    	probs.put(Species.SHARK, ModelConstants.CREATION_ODDS_SHARK);
    	
    	Float totalOdds = 0f;
    	for (Species species : probs.keySet()) {
    		totalOdds += probs.get(species);
    	}
    	
    	float finalRand = randomNumber * totalOdds;
    	float subtotal = 0;
    	for(Species species : probs.keySet()) {
    		subtotal += probs.get(species);
    		if (finalRand < subtotal) {
    			System.out.println(finalRand);
    		}
    	}
    	return Species.EMPTY;
    	
        /*if(randomNumber <= ModelConstants.CREATION_ODDS_SHARK) {
            return Species.SHARK;
        }
        else if(randomNumber <= ModelConstants.CREATION_ODDS_SARDINE) {
            return Species.SARDINE;
        }
        else if(randomNumber <= ModelConstants.CREATION_ODDS_PLANKTON) {
            return Species.PLANKTON;
        }
        else {
            return Species.EMPTY;
        }*/
    }
	
	public void startSimulation() {
		populate();
		view.showStatus(0, field);
	}
	
}
