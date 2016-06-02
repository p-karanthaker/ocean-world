package uk.ac.aston.dc2300.ocean.life;

import java.util.Random;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;
import uk.ac.aston.dc2300.ocean.world.RandomGenerator;

/**
 * Creature class.
 * 
 * @author Karan Thaker
 *
 */
abstract public class Creature {
    
    	/**
	 * Random generator to create random numbers
	 */
	private Random random = RandomGenerator.getRandom();
        
        /**
	 * holds the age of the creature at each step
	 */
	private int age;
        
        /**
	 * Holds the location of the creature at each step
	 */
	private Location location;
	
        /**
	 * represents if the creature is dead or alive
	 */
        private boolean alive;
	
        /**
	 * Holds the what type of animal the creature is
	 */
        private Species species;
	
        
        /**
	 * Provides a species type and information on if there origin of birth and its 
         * location
	 * @param species the species type of creature
         * @param isBaby if it is a creature as a result of breeding
         * @param initialLocation its first location
	 */
	public Creature(Species species, boolean isBaby, Location initialLocation) {
		this.species = species;
		this.location = initialLocation;
		this.alive = true;
		this.age = isBaby ? 0 : random.nextInt(getMaxAge() + 1);
	}
	
	/**
	 * Performs the basic actions that all creatures share the same implementation
         * of
	 * @param field the current 2D array representing the environment 
	 */
	public void act(Field field) {
		// Increment age for all creatures
		incrementAge();
	}
    
	/**
	 * Based on a random generator, this decides and creates a new creature
	 * @param field the current 2D array representing the environment
	 * @return a baby creature created at a location adjacent to the parent creature
	 */
        public Creature breed(Field field) {
        Random rand = RandomGenerator.getRandom();
        
        double randomNumber = rand.nextDouble();
        
        //If the creature is of breeding age and the random number drawn is within
        //breeding boundary, creature the creature
        if((getAge() >= getBreedingAge()) && (randomNumber <= getBreedingOdds())){
            return giveBirth(field);
        }
        
		return null;
        }

        /**
         * Actually creates a baby creature if there is room
         * @param field the current 2D array representing the environment
         * @return a baby creature created at a location adjacent to the parent creature
         */
        private Creature giveBirth(Field field){
        Location babyLocation = null;
        
        //Try to get potential baby location
        babyLocation = field.freeAdjacentLocation(this.getLocation());
        
        //If there is space for the baby make one
        if(babyLocation != null){
           //Create the baby creature using the factory
           Creature baby = CreatureFactory.getCreature(this.getSpecies(), true, babyLocation);
           
           //Place it in the ocean
           field.place(baby, babyLocation);
           return baby;
        }
		return null;
        }
          
        /**
	 * Increments the age of the creature
	 */
	private void incrementAge() {
		setAge(getAge() + 1);
	}
	
        /**
	 * @return the chances of creature giving birth
	 */
	abstract public double getBreedingOdds();
	
        /**
	 * @return the max age the creature can reach before death by old
         * age
	 */
	abstract public int getMaxAge();
	
        /**
	 * @return the minimal age the creature can be at before breeding is possible
         * for it
	 */
	abstract public double getBreedingAge();
	
        /**
	 * @return how much the food level of a creature will increase if 
         * it is capable and eats this creature
	 */
	abstract public int getNutritionalValue();
	
	
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
		return species;
	}

	/**
	 * 
	 * @return if the creature is alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * mark creature as dead for removal
	 */
	public void setNotAlive() {
		this.alive = false;
	}
	
}
