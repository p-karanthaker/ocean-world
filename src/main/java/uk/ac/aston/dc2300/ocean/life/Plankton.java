package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

public class Plankton extends Creature {
	
	public Plankton(int maxAge, int minBreedingAge, int nutritionalValue, 
			float creationOdds, float breedingOdds) {
		super(maxAge, minBreedingAge, nutritionalValue, creationOdds, breedingOdds);
	}

	@Override
	public void reproduce() {
		// Create a baby Plankton? Super-method will set location?
		super.reproduce();
	}
	
}
