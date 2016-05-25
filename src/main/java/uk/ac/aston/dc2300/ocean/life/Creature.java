package uk.ac.aston.dc2300.ocean.life;

import java.util.Random;

import uk.ac.aston.dc2300.ocean.world.CreatureFactory;
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
	private int nutritionalValue = 0;
	
	private Species SPECIES;
	
	public Creature(Species species, boolean isAgeZero, Location initialLocation) {
		this.location = initialLocation;
		this.setIsAlive(true);
		switch (species) {
			case PLANKTON:
				SPECIES = species;
				maxAge = ModelConstants.MAXIMUM_AGE_PLANKTON;
				nutritionalValue = ModelConstants.NUTRITIONAL_VALUE_PLANKTON;
				this.age = isAgeZero ? 0 : RandomGenerator.getRandom().nextInt(getMaxAge() + 1);
				break;
			case SARDINE:
				SPECIES = species;
				maxAge = ModelConstants.MAXIMUM_AGE_SARDINE;
				nutritionalValue = ModelConstants.NUTRITIONAL_VALUE_SARDINE;
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
		incrementAge();
        // TODO food levels
	}
        
    public Creature breed(Field field) {
        Random rand = RandomGenerator.getRandom();
        
        double randomNumber = rand.nextDouble();
        double birthProb = 0;
        int ageOfConsent = 0;
       
		switch (this.getSpecies()) {
			case PLANKTON:
				birthProb = ModelConstants.BREEDING_ODDS_PLANKTON;
				ageOfConsent = ModelConstants.BREEDING_AGE_PLANKTON;
				break;
			case SARDINE:
				birthProb = ModelConstants.BREEDING_ODDS_SARDINE;
				ageOfConsent = ModelConstants.BREEDING_AGE_SARDINE;
				break;
			case SHARK:
				birthProb = ModelConstants.BREEDING_ODDS_SHARK;
				ageOfConsent = ModelConstants.BREEDING_AGE_SHARK;
				break;
			default:
				break;
		} 
        
        if((getAge() >= ageOfConsent) && (randomNumber <= birthProb)){
            //System.out.println("BABY: " + "Species: " + this.getSpecies() + " " + randomNumber);
            return giveBirth(field);
        }
		return null;
    }

    private Creature giveBirth(Field field){
        Location babyLocation = null;
        
        //Try to get potential baby location
        babyLocation = field.freeAdjacentLocation(this.getLocation());
        
        //If there is space for the baby make one
        if(babyLocation != null){
           Creature baby = CreatureFactory.getCreature(this.getSpecies(), true, babyLocation);
           field.place(baby, babyLocation);
           return baby;
        }
		return null;
    }
          
        
	private void incrementAge() {
		setAge(getAge() + 1);
	}
	
	// Getters and Setters
	
	public int getNutritionalValue() {
		return nutritionalValue;
	}
	
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
