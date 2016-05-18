package uk.ac.aston.dc2300.ocean.life;

public class Plankton extends Creature {
	
	public Plankton() {
		super(Species.PLANKTON);
	}

	@Override
	public void reproduce() {
		// Create a baby Plankton? Super-method will set location?
		super.reproduce();
	}
	
}
