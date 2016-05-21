package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

public class Sardine extends Fish {

	public Sardine(boolean isAgeZero, Location initialLocation) {
		super(Species.SARDINE, isAgeZero, initialLocation);
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
