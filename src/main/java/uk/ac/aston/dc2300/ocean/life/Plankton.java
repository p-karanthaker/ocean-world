package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

public class Plankton extends Creature {
	
	public Plankton(int maxAge, int minBreedingAge, int nutritionalValue, 
			float creationOdds, float breedingOdds, Location initialLocation) {
		super(maxAge, minBreedingAge, nutritionalValue, creationOdds, breedingOdds, initialLocation);
	}

	@Override
	public void reproduce() {
		// Create a baby Plankton? Super-method will set location?
		super.reproduce();
	}
	
}
