package uk.ac.aston.dc2300.ocean.world;

import java.awt.Color;
import java.util.Random;

import uk.ac.aston.dc2300.ocean.life.Plankton;
import uk.ac.aston.dc2300.ocean.life.Sardine;
import uk.ac.aston.dc2300.ocean.life.Shark;
import uk.ac.aston.dc2300.ocean.life.Species;

public class Simulator {

	private static Field field;
	private static SimulatorView view;
	private static Simulator sim;
	
	public static void main(String[] args) {
		startSimulation();
	}
	
	public Simulator() {
		// TODO Auto-generated constructor stub
	}
	
	public Simulator(int width, int depth) {
		field = new Field(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);
<<<<<<< HEAD
		
		view = new SimulatorView(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);
=======

		view = new SimulatorView(50, 50);
>>>>>>> refs/remotes/origin/dev
		view.setColor(Plankton.class, Color.GREEN);
		view.setColor(Sardine.class, Color.DARK_GRAY);
		view.setColor(Shark.class, Color.CYAN);
	}
	
<<<<<<< HEAD
	public static void populate() {
=======
	public void populate() {
                //Holds the value of the specides chosen randomly
                Species decicedCreature;
                RandomGenerator.initialiseWithSeed(ModelConstants.RNG_SEED);
                Random rand = RandomGenerator.getRandom();
>>>>>>> refs/remotes/origin/dev
		field.clear();
                
                
                //Cycle through all locations in the field
                for(int d = 0; d < field.getDepth(); d++){
                    for(int w = 0; w < field.getWidth(); w++){
                        
                        //Use a random number generator to decide what creature to create
                        decicedCreature = creationDecider(rand.nextInt(100));
                        
                        //Create the creature and place in field
                        field.place(CreatureFactory.getCreature(decicedCreature), new Location(d, w));
                    }
                }
	}
        
        //Decides what type of creature needs to be created
        private Species creationDecider(int randomNumber)
        {
            if(0 <= randomNumber && randomNumber <= 69){
                return Species.PLANKTON;
            }
            else if(70 <= randomNumber && randomNumber <= 79){
                return Species.SARDINE ;
            }
            else if(80 <= randomNumber && randomNumber <= 84){
                return Species.SHARK;
            }
            else{
                return Species.EMPTY;
            }
        }
	
	public static void startSimulation() {
		sim = new Simulator(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);
		populate();
		view.showStatus(0, field);
	}
	
}
