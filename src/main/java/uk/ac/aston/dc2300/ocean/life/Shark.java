package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

public class Shark extends Fish {

	public Shark(int maxAge, int minBreedingAge, int nutritionalValue, float creationOdds, float breedingOdds,
			Location initialLocation) {
		super(maxAge, minBreedingAge, nutritionalValue, creationOdds, breedingOdds, initialLocation);
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
