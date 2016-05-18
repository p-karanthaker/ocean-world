package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

public class Sardine extends Fish {

	public Sardine(int maxAge, int minBreedingAge, int nutritionalValue, float creationOdds, float breedingOdds) {
		super(maxAge, minBreedingAge, nutritionalValue, creationOdds, breedingOdds);
	}

	@Override
	public void eat(Creature creature) {
		// TODO Implement Sardine eating Plankton. Food Level will change in super-method.
		super.eat(creature);
	}
	
	@Override
	public void reproduce() {
		// TODO Create a baby Sardine? Super-method will set location?
		super.reproduce();
	}
	
}
