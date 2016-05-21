package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;
import uk.ac.aston.dc2300.ocean.world.ModelConstants;
import uk.ac.aston.dc2300.ocean.world.RandomGenerator;

/**
 * Creature class.
 * 
 * @author Karan Thaker
 *
 */
public class Creature {
	
	private int age;
	private Location location;
	
	private Species SPECIES;
	
	public Creature(Species species, boolean isAgeZero, Location initialLocation) {
		this.location = initialLocation;
		switch (species) {
			case PLANKTON:
				SPECIES = species;
				this.age = isAgeZero ? 0 : RandomGenerator.getRandom().nextInt(ModelConstants.MAXIMUM_AGE_PLANKTON + 1);
			case SARDINE:
				SPECIES = species;
				this.age = isAgeZero ? 0 : RandomGenerator.getRandom().nextInt(ModelConstants.MAXIMUM_AGE_SARDINE + 1);
			case SHARK:
				SPECIES = species;
				this.age = isAgeZero ? 0 : RandomGenerator.getRandom().nextInt(ModelConstants.MAXIMUM_AGE_SHARK + 1);
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
	 * 
	 * @return the SPECIES of the Creature
	 */
	public Species getSpecies() {
		return SPECIES;
	}
	
}
