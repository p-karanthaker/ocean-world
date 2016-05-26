package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;
import uk.ac.aston.dc2300.ocean.world.ModelConstants;

public class Shark extends Fish {

	public Shark(boolean isAgeZero, Location initialLocation) {
		super(Species.SHARK, isAgeZero, initialLocation, Species.SARDINE);
	}

	@Override
	public void act(Field field) {
		super.act(field);
	}

	@Override
	public double getBreedingOdds() {
		return ModelConstants.BREEDING_ODDS_SHARK;
	}

	@Override
	public int getMaxAge() {
		return ModelConstants.MAXIMUM_AGE_SHARK;
	}

	@Override
	public double getBreedingAge() {
		return ModelConstants.BREEDING_AGE_SHARK;
	}

	@Override
	public int getNutritionalValue() {
		return 0;
	}
	
}
