package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

public class Shark extends Fish {

	public Shark(boolean isAgeZero, Location initialLocation) {
		super(Species.SHARK, isAgeZero, initialLocation);
	}

	@Override
	public void eat(Creature creature) {
		// TODO Implement Shark eating Sardine. Food Level will change in super-method.
		super.eat(creature);
	}
	
	@Override
	public void reproduce() {
		// TODO Create a baby Shark?
	}

	@Override
	public void act(Field field) {
		// TODO Auto-generated method stub
		
	}
	
}
