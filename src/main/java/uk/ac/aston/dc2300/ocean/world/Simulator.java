package uk.ac.aston.dc2300.ocean.world;

import java.awt.Color;
import java.awt.Dimension;

import uk.ac.aston.dc2300.ocean.life.Creature;
import uk.ac.aston.dc2300.ocean.life.Plankton;
import uk.ac.aston.dc2300.ocean.life.Sardine;
import uk.ac.aston.dc2300.ocean.life.Shark;

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
		Creature plankton = new Plankton(100, 0, 4, 0.7f, 0.8f);
		Creature sardine = new Sardine(75, 12, 14, 0.1f, 0.5f);
		Creature shark = new Shark(150, 25, 0, 0.05f, 0.2f);
		field.clear();
		field.place(plankton, new Location(10, 10));
		field.place(sardine, new Location(20, 20));
		field.place(shark, new Location(30, 30));
	}
	
	public void startSimulation() {
		populate();
		view.showStatus(0, field);
	}
	
}
