package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

abstract public class Fish extends Creature {

	private int foodLevel;
	
	public Fish(Species species, boolean isAgeZero, Location initialLocation) {
		super(species, isAgeZero, initialLocation);
		// TODO Auto-generated constructor stub
	}
	
	public void swim() {
		// TODO Implement swimming
	}
	
	public void eat(Creature creature) {
		// TODO Implement eating fully
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

	
	
}
