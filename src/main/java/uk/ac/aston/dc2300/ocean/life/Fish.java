package uk.ac.aston.dc2300.ocean.life;

import java.util.Iterator;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

abstract public class Fish extends Creature {

	private int foodLevel;
	private Species prey;
	
	public Fish(Species species, boolean isAgeZero, Location initialLocation, Species prey) {
		super(species, isAgeZero, initialLocation);
		this.prey = prey;
		this.foodLevel = getPreyNutritionalValue();
	}
	
	abstract public int getPreyNutritionalValue();
	
	/**
	 * @return the foodLevel
	 */
	public int getFoodLevel() {
		return foodLevel;
	}

	/**
	 * @param foodLevel the foodLevel to set
	 */
	public void decreaseFoodLevel() {
		this.foodLevel--;
	}
	
	public Species getPrey() {
		return prey;
	}

	@Override
	public void act(Field field) {
		// increment age
		super.act(field);
		decreaseFoodLevel();
		
		if (getFoodLevel() > 0) {
			// Find food, also find a new location.
			Location food = findFood(field);
			Location newLocation = field.freeAdjacentLocation(getLocation());
			
			// First check if food was found...
			if(food != null) {
				eatFood(field, food);
			// otherwise check if a new location was found...
			} else if(newLocation != null) {
				// move
				move(field, getLocation(), newLocation);
			} else {
				// If the fish can't move it dies of over-crowding
	            this.setNotAlive();
	            field.place(null, getLocation());
			}
		} else {
			this.setNotAlive();
			field.place(null, getLocation());
		}
	}
	
	/**
	 * Eats the food at the given location.
	 * @param field
	 * @param foodLocation
	 */
    public void eatFood(Field field, Location foodLocation) {
        Creature creature = field.getObjectAt(foodLocation);
        creature.setNotAlive();
        
        this.foodLevel += creature.getNutritionalValue();
        
        // take the creatures location
        Location oldLocation = getLocation();
        move(field, oldLocation, foodLocation);
    }
	
    /**
     * Try to find edible food.
     * @param field
     * @return the first occurrence of an edible food. Otherwise null.
     */
	@SuppressWarnings("unchecked")
	public Location findFood(Field field) {
		Iterator<Location> adjacent = field.adjacentLocations(getLocation());
		while(adjacent.hasNext()) {
			Location next = adjacent.next();
			Creature creature = field.getObjectAt(next);
			if((creature != null) && (creature.getSpecies().equals(getPrey()))) {
				return next;
			}
		}
		return null;
	}
		
	/**
	 * Move the creature to a new location on the field
	 * @param field
	 * @param oldLocation
	 * @param newLocation
	 */
	public void move(Field field, Location oldLocation, Location newLocation) {
        //Set new location
        setLocation(newLocation);
        
        //Move to new position
        field.place(this, newLocation);
        field.place(null, oldLocation);
	}
	
}
