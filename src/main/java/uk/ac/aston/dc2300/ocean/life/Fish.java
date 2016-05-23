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
	}
	
	/**
	 * @return the foodLevel
	 */
	public int getFoodLevel() {
		return foodLevel;
	}

	/**
	 * @param foodLevel the foodLevel to set
	 */
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}
	
	public Species getPrey() {
		return prey;
	}

	@Override
	public void act(Field field) {
		// increment age
		super.act(field);
		Location food = findFood(field);
		Location newLocation = field.freeAdjacentLocation(getLocation());
		if(food != null) {
			eatFood(field, food);
		} else if(newLocation != null) {
			// move
			move(field, getLocation(), newLocation);
		} else {
			//System.out.println("dead");
		}
	}
	
    public void eatFood(Field field, Location foodLocation) {
        Creature creature = field.getObjectAt(foodLocation);
        creature.setIsAlive(false);
        
        setFoodLevel(this.getFoodLevel() + 1);
        
        // take the creatures location
        move(field, getLocation(), foodLocation);
    }
	
	public Location findFood(Field field) {
		Iterator<Location> adjacent = field.adjacentLocations(getLocation());
		while(adjacent.hasNext()) {
			Location next = (Location) adjacent.next();
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
