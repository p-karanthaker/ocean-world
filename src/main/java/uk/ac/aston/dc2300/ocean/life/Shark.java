package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;
import uk.ac.aston.dc2300.ocean.world.ModelConstants;

public class Shark extends Fish {

	/**
	 * Provides a species type and information on if there origin of birth and
	 * its location
	 * 
	 * @param isAgeZero
	 *            if the creatures age starts at 0
	 * @param initialLocation
	 *            its first location
	 */
	public Shark(boolean isAgeZero, Location initialLocation) {
		super(Species.SHARK, isAgeZero, initialLocation, Species.SARDINE);
	}

	/**
	 * Performs all the actions of the creatures such as swim, eat and breed
	 * 
	 * @param field
	 *            the current 2D array representing the environment
	 */
	@Override
	public void act(Field field) {
		super.act(field);
	}

	/**
	 * @return the chances this creature will breed
	 */
	@Override
	public double getBreedingOdds() {
		return ModelConstants.BREEDING_ODDS_SHARK;
	}

	/**
	 * @return the max age the creature will reach before dying
	 */
	@Override
	public int getMaxAge() {
		return ModelConstants.MAXIMUM_AGE_SHARK;
	}

	/**
	 * @return the minimum age the creature can be before trying to breed
	 */
	@Override
	public double getBreedingAge() {
		return ModelConstants.BREEDING_AGE_SHARK;
	}

	/**
	 * @return the amount of food level gain by eating this creature
	 */
	@Override
	public int getNutritionalValue() {
		return 0;
	}

	/**
	 * @return the amount of food level gain by eating this creature's prey
	 */
	@Override
	public int getPreyNutritionalValue() {
		return ModelConstants.NUTRITIONAL_VALUE_SARDINE;
	}

}
