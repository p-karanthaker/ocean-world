package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

public class Shark extends Fish {

	public Shark(boolean isAgeZero, Location initialLocation) {
		super(Species.SHARK, isAgeZero, initialLocation);
	}

	@Override
	public void act(Field field) {
		if(findFood(field).isEmpty()) {
			// move somewhere using super?
			super.act(field);
		} else {
			// try to eat
		}
	}
	
}
