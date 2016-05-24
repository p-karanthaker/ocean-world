package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;
import uk.ac.aston.dc2300.ocean.world.ModelConstants;
import uk.ac.aston.dc2300.ocean.world.RandomGenerator;

/**
 * Creature class.
 * 
 * @author Karan Thaker
 *
 */
abstract public class Creature {
	
	private int age;
	private Location location;
	private boolean isAlive;
	private int maxAge;
	
	private Species SPECIES;
	
	public Creature(Species species, boolean isAgeZero, Location initialLocation) {
		this.location = initialLocation;
		this.setIsAlive(true);
		switch (species) {
			case PLANKTON:
				SPECIES = species;
				maxAge = ModelConstants.MAXIMUM_AGE_PLANKTON;
				this.age = isAgeZero ? 0 : RandomGenerator.getRandom().nextInt(getMaxAge() + 1);
				break;
			case SARDINE:
				SPECIES = species;
				maxAge = ModelConstants.MAXIMUM_AGE_SARDINE;
				this.age = isAgeZero ? 0 : RandomGenerator.getRandom().nextInt(getMaxAge() + 1);
				break;
			case SHARK:
				SPECIES = species;
				maxAge = ModelConstants.MAXIMUM_AGE_SHARK;
				this.age = isAgeZero ? 0 : RandomGenerator.getRandom().nextInt(getMaxAge() + 1);
				break;
			default:
				return;
		}
	}
	
	public void act(Field field) {
		// Increment age for all creatures
		if (getAge()+1 < getMaxAge()) {
			incrementAge();
		} else {
			setIsAlive(false);
		}
		return;
	}
	
	private void incrementAge() {
		setAge(getAge() + 1);
	}
	
	// Getters and Setters
	
	public int getMaxAge() {
		return maxAge;
	}
	
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
	 * 
	 * @return the SPECIES of the Creature
	 */
	public Species getSpecies() {
		return SPECIES;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
