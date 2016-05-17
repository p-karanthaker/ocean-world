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
		Simulator sim = new Simulator(new Dimension(50, 50));
		
		sim.startSimulation();
	}
	
	public Simulator(Dimension fieldDimension) {
		field = new Field(fieldDimension.height, fieldDimension.width);
		
		view = new SimulatorView(50, 50);
		view.setColor(Plankton.class, Color.GREEN);
		view.setColor(Sardine.class, Color.DARK_GRAY);
		view.setColor(Shark.class, Color.CYAN);
	}
	
	public void populate() {
		Creature plankton = new Plankton(100, 0, 4, 0.7f, 0.8f, new Location(10, 10));
		Creature sardine = new Sardine(75, 12, 14, 0.1f, 0.5f, new Location(20, 20));
		Creature shark = new Shark(150, 25, 0, 0.05f, 0.2f, new Location(30, 30));
		field.clear();
		field.place(plankton, plankton.getLocation());
		field.place(sardine, sardine.getLocation());
		field.place(shark, shark.getLocation());
	}
	
	public void startSimulation() {
		populate();
		view.showStatus(0, field);
	}
	
}
