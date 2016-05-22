package uk.ac.aston.dc2300.ocean.life;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

abstract public class Fish extends Creature {

	private int foodLevel;
	
	public Fish(Species species, boolean isAgeZero, Location initialLocation) {
		super(species, isAgeZero, initialLocation);
		// TODO Auto-generated constructor stub
	}
	
	protected List<Location> findFood(Field field) {
		List<Location> locations = new ArrayList<Location>();
		Iterator<Location> adjacent = field.adjacentLocations(getLocation());
		while(adjacent.hasNext()) {
			Location next = (Location) adjacent.next();
			if(field.getObjectAt(next) != null) {
				locations.add(next);
			}
		}
		return locations;
	}
	
	protected void swim(Field field) {
		Location newLocation = field.freeAdjacentLocation(getLocation());
        if(newLocation != null) {
            
            Location oldLocation = getLocation();
            
            //Set new location
            setLocation(newLocation);
                
            //Move to new creature
            field.place(this, newLocation);
            field.place(null, oldLocation);
        }
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

	@Override
	public void act(Field field) {
		// increment age
		super.act(field);
		if(findFood(field).isEmpty()) {
			swim(field);
		} else {
			eatFood(findFood(field), field);
		}
	}
        
    public abstract void eatFood(List<Location> possibleFood, Field field);
	
	
}
