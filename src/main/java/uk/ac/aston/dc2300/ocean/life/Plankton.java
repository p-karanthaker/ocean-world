package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;
import uk.ac.aston.dc2300.ocean.world.ModelConstants;

public class Plankton extends Creature {

	/**
	 * Provides a species type and information on if there origin of birth and
	 * its location
	 * 
	 * @param isAgeZero
	 *            if the creatures age starts at 0
	 * @param initialLocation
	 *            its first location
	 */
	public Plankton(boolean isAgeZero, Location initialLocation) {
		super(Species.PLANKTON, isAgeZero, initialLocation);
	}

	/**
	 * @return the chances this creature will breed
	 */
	@Override
	public double getBreedingOdds() {
		return ModelConstants.BREEDING_ODDS_PLANKTON;
	}

	/**
	 * @return the max age the creature will reach before dying
	 */
	@Override
	public int getMaxAge() {
		return ModelConstants.MAXIMUM_AGE_PLANKTON;
	}

	/**
	 * @return the minimum age the creature can be before trying to breed
	 */
	@Override
	public double getBreedingAge() {
		return ModelConstants.BREEDING_AGE_PLANKTON;
	}

	/**
	 * @return the amount of food level gain by eating this creature
	 */
	@Override
	public int getNutritionalValue() {
		return ModelConstants.NUTRITIONAL_VALUE_PLANKTON;
	}

}
