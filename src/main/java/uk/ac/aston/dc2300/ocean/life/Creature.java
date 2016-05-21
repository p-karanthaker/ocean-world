package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;
import uk.ac.aston.dc2300.ocean.world.ModelConstants;

/**
 * Creature class.
 * 
 * @author Karan Thaker
 *
 */
public class Creature {
	
	/* Constants */
	private static double CREATION_ODDS;
	private static double BREEDING_ODDS;
	private static int MAXIMUM_AGE;
	private static int BREEDING_AGE;
	private static int NUTRITIONAL_VALUE;
	
	private int age;
	private Location location;
	
	private static Species SPECIES;
	
	public Creature(Species species) {
		this.age = 0;
		switch (species) {
			case PLANKTON:
				SPECIES = species;
				CREATION_ODDS = ModelConstants.CREATION_ODDS_PLANKTON;
				BREEDING_ODDS = ModelConstants.BREEDING_ODDS_PLANKTON;
				MAXIMUM_AGE = ModelConstants.MAXIMUM_AGE_PLANKTON;
				BREEDING_AGE = ModelConstants.BREEDING_AGE_PLANKTON;
				NUTRITIONAL_VALUE = ModelConstants.NUTRITIONAL_VALUE_PLANKTON;				
			case SARDINE:
				SPECIES = species;
				CREATION_ODDS = ModelConstants.CREATION_ODDS_SARDINE;
				BREEDING_ODDS = ModelConstants.BREEDING_ODDS_SARDINE;
				MAXIMUM_AGE = ModelConstants.MAXIMUM_AGE_SARDINE;
				BREEDING_AGE = ModelConstants.BREEDING_AGE_SARDINE;
				NUTRITIONAL_VALUE = ModelConstants.NUTRITIONAL_VALUE_SARDINE;
			case SHARK:
				SPECIES = species;
				CREATION_ODDS = ModelConstants.CREATION_ODDS_SHARK;
				BREEDING_ODDS = ModelConstants.BREEDING_ODDS_SHARK;
				MAXIMUM_AGE = ModelConstants.MAXIMUM_AGE_SHARK;
				BREEDING_AGE = ModelConstants.BREEDING_AGE_SHARK;
				NUTRITIONAL_VALUE = 0;
			default:
				return;
		}
	}
	
	public void reproduce() {
		// TODO Implement reproducing
		// Set the location of the new Creature here?
	}
	
	// Getters and Setters
	
	/**
	 * @return the age of the Creature
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set for the Creature
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the location of the Creature
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set for the Creature
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the MAX_AGE of the Creature
	 */
	public int getMaxAge() {
		return MAXIMUM_AGE;
	}

	/**
	 * @return the MIN_BREEDING_AGE of the Creature
	 */
	public int getMinBreedingAge() {
		return BREEDING_AGE;
	}

	/**
	 * @return the NUTRITIONAL_VALUE of the Creature
	 */
	public int getNutritionalValue() {
		return NUTRITIONAL_VALUE;
	}

	/**
	 * @return the CREATION_ODDS of the Creature
	 */
	public double getCreationOdds() {
		return CREATION_ODDS;
	}

	/**
	 * @return the BREEDING_ODDS of the Creature
	 */
	public double getBreedingOdds() {
		return BREEDING_ODDS;
	}
	
	/**
	 * 
	 * @return the SPECIES of the Creature
	 */
	public Species getSpecies() {
		return SPECIES;
	}
	
}
