package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;
import uk.ac.aston.dc2300.ocean.world.ModelConstants;

public class Plankton extends Creature {
	
	public Plankton(boolean isAgeZero, Location initialLocation) {
		super(Species.PLANKTON, isAgeZero, initialLocation);
	}

	@Override
	public void act(Field field) {
		super.act(field);
	}

	@Override
	public double getBreedingOdds() {
		return ModelConstants.BREEDING_ODDS_PLANKTON;
	}

	@Override
	public int getMaxAge() {
		return ModelConstants.MAXIMUM_AGE_PLANKTON;
	}

	@Override
	public double getBreedingAge() {
		return ModelConstants.BREEDING_AGE_PLANKTON;
	}

	@Override
	public int getNutritionalValue() {
		return ModelConstants.NUTRITIONAL_VALUE_PLANKTON;
	}
	
}
