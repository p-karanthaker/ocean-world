package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

/**
 * Creature class.
 * 
 * @author Karan Thaker
 *
 */
public class Creature {
	
	/* Constants */
	private final int MAX_AGE;
	private final int MIN_BREEDING_AGE;
	private final int NUTRITIONAL_VALUE;
	private final float CREATION_ODDS;
	private final float BREEDING_ODDS;
	
	private int age;
	private Location location;
	
	public Creature(int maxAge, int minBreedingAge, int nutritionalValue, 
			float creationOdds, float breedingOdds) {
		this.MAX_AGE = maxAge;
		this.MIN_BREEDING_AGE = minBreedingAge;
		this.NUTRITIONAL_VALUE = nutritionalValue;
		this.CREATION_ODDS = creationOdds;
		this.BREEDING_ODDS = breedingOdds;
		this.age = 0;
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
		return MAX_AGE;
	}

	/**
	 * @return the MIN_BREEDING_AGE of the Creature
	 */
	public int getMinBreedingAge() {
		return MIN_BREEDING_AGE;
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
	public float getCreationOdds() {
		return CREATION_ODDS;
	}

	/**
	 * @return the BREEDING_ODDS of the Creature
	 */
	public float getBreedingOdds() {
		return BREEDING_ODDS;
	}
	
}
