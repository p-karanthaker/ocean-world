package uk.ac.aston.dc2300.ocean.life;

import java.util.Random;

import uk.ac.aston.dc2300.ocean.world.CreatureFactory;
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
	private Random random = RandomGenerator.getRandom();
	
	private int age;
	private Location location;
	private boolean alive;
	
	private Species species;
	
	public Creature(Species species, boolean isBaby, Location initialLocation) {
		this.species = species;
		this.location = initialLocation;
		this.alive = true;
		this.age = isBaby ? 0 : random.nextInt(getMaxAge() + 1);
	}
	
	/**
	 * 
	 * @param field
	 */
	public void act(Field field) {
		// Increment age for all creatures
		incrementAge();
	}
    
	/**
	 * 
	 * @param field
	 * @return
	 */
    public Creature breed(Field field) {
        Random rand = RandomGenerator.getRandom();
        
        double randomNumber = rand.nextDouble();
        
        if((getAge() >= getBreedingAge()) && (randomNumber <= getBreedingOdds())){
            //System.out.println("BABY: " + "Species: " + this.getSpecies() + " " + randomNumber);
            return giveBirth(field);
        }
        
		return null;
    }

    /**
     * 
     * @param field
     * @return
     */
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
	
	abstract public double getBreedingOdds();
	
	abstract public int getMaxAge();
	
	abstract public double getBreedingAge();
	
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
	 * @return
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * 
	 */
	public void setNotAlive() {
		this.alive = false;
	}
	
}
