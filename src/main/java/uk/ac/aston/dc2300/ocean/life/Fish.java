package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

abstract public class Fish extends Creature {

	private int foodLevel;
	
	public Fish(Species species, boolean isAgeZero, Location initialLocation) {
		super(species, isAgeZero, initialLocation);
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
	
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
		super.act(field);
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
	
	
}
