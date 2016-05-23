package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

public class Plankton extends Creature {
	
	public Plankton(boolean isAgeZero, Location initialLocation) {
		super(Species.PLANKTON, isAgeZero, initialLocation);
	}

	@Override
	public void act(Field field) {
		super.act(field);
		// reproduce
	}
	
}
