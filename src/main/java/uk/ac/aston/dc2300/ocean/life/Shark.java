package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

public class Shark extends Fish {

	public Shark(Location initialLocation) {
		super(Species.SHARK, initialLocation);
	}

	@Override
	public void eat(Creature creature) {
		// TODO Implement Shark eating Sardine. Food Level will change in super-method.
		super.eat(creature);
	}
	
	@Override
	public void reproduce() {
		// TODO Create a baby Shark? Super-method will set location?
		super.reproduce();
	}
	
}
