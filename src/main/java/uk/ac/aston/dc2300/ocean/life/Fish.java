package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

public class Fish extends Creature {

	private int foodLevel;
	
	public Fish(int maxAge, int minBreedingAge, int nutritionalValue, float creationOdds, float breedingOdds) {
		super(maxAge, minBreedingAge, nutritionalValue, creationOdds, breedingOdds);
		// TODO Auto-generated constructor stub
	}
	
	public void swim() {
		// TODO Implement swimming
	}
	
	public void eat(Creature creature) {
		// TODO Implement eating fully
		setFoodLevel(getFoodLevel() + creature.getNutritionalValue());
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
