package uk.ac.aston.dc2300.ocean.world;

import java.awt.Color;

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
		
		view = new SimulatorView(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);
		view.setColor(Plankton.class, Color.GREEN);
		view.setColor(Sardine.class, Color.DARK_GRAY);
		view.setColor(Shark.class, Color.CYAN);
	}
	
	public static void populate() {
		field.clear();
		field.place(CreatureFactory.getCreature(Species.PLANKTON), new Location(10, 10));
		field.place(CreatureFactory.getCreature(Species.SARDINE), new Location(20, 20));
		field.place(CreatureFactory.getCreature(Species.SHARK), new Location(30, 30));
	}
	
	public static void startSimulation() {
		sim = new Simulator(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);
		populate();
		view.showStatus(0, field);
	}
	
}
