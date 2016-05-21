package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

public class Plankton extends Creature {
	
	public Plankton(boolean isAgeZero, Location initialLocation) {
		super(Species.PLANKTON, isAgeZero, initialLocation);
	}

	@Override
	public void reproduce() {
		// Create a baby Plankton? Super-method will set location?
		super.reproduce();
	}
	
}
