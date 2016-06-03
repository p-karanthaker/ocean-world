package uk.ac.aston.dc2300.ocean.life;

import java.util.Iterator;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

abstract public class Fish extends Creature {

	/**
	 * Holds the hunger value of the fish
	 */
	private int foodLevel;

	/**
	 * Records the type of creature the fish is able to eat
	 */
	private Species prey;

	/**
	 * Provides a species type and information on what this creature eats and
	 * its hunger level location
	 * 
	 * @param species
	 *            the species type of creature
	 * @param isAgeZero
	 *            if the age of the creature is to start at 0
	 * @param initialLocation
	 *            its first location
	 * @param prey
	 *            the type of creature this creature can eat
	 */
	public Fish(Species species, boolean isAgeZero, Location initialLocation, Species prey) {
		super(species, isAgeZero, initialLocation);
		this.prey = prey;
		this.foodLevel = getPreyNutritionalValue();
	}

	/**
	 * @return the value gain in food level from consuming this creatures prey
	 */
	abstract public int getPreyNutritionalValue();

	/**
	 * @return the foodLevel
	 */
	public int getFoodLevel() {
		return foodLevel;
	}

	/**
	 * decreases food level by 1
	 */
	public void decreaseFoodLevel() {
		this.foodLevel--;
	}

	/**
	 * @return the Species of this object
	 */
	public Species getPrey() {
		return prey;
	}

	/**
	 * Performs all the actions of the creatures such as swim, eat and breed
	 * 
	 * @param field
	 *            the current 2D array representing the environment
	 */
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
			if (food != null) {
				eatFood(field, food);
				// otherwise check if a new location was found...
			} else if (newLocation != null) {
				// move
				move(field, getLocation(), newLocation);
			} else {
				// If the fish can't move it dies of over-crowding
				this.setNotAlive();
				field.place(null, getLocation());
			}
		}
		// If the food level of the fish is 0 or below it dies and needs to be
		// removed
		else {
			this.setNotAlive();
			field.place(null, getLocation());
		}
	}

	/**
	 * Eats the food at the given location.
	 * 
	 * @param field
	 *            the current 2D array representing the environment
	 * @param foodLocation
	 *            the location of the adjacent creature this creature can eat
	 */
	public void eatFood(Field field, Location foodLocation) {

		// get the prey
		Creature creature = field.getObjectAt(foodLocation);

		// mark the prey as dead as it is being eaten
		creature.setNotAlive();

		// increase the food level of this creature by the nutrional value of
		// what
		// just ate
		this.foodLevel += creature.getNutritionalValue();

		// take the creatures location
		Location oldLocation = getLocation();
		move(field, oldLocation, foodLocation);
	}

	/**
	 * Try to find edible food.
	 * 
	 * @param field
	 *            the current 2D array representing the environment
	 * @return the first occurrence of an edible food. Otherwise null.
	 */
	@SuppressWarnings("unchecked")
	public Location findFood(Field field) {
		Iterator<Location> adjacent = field.adjacentLocations(getLocation());
		while (adjacent.hasNext()) {
			Location next = adjacent.next();
			Creature creature = field.getObjectAt(next);
			if ((creature != null) && (creature.getSpecies().equals(getPrey()))) {
				return next;
			}
		}
		return null;
	}

	/**
	 * Move the creature to a new location on the field
	 * 
	 * @param field
	 *            the current 2D array representing the environment
	 * @param oldLocation
	 *            the location the creature is moving from
	 * @param newLocation
	 *            the location the creature is moving to
	 */
	public void move(Field field, Location oldLocation, Location newLocation) {
		// Set new location
		setLocation(newLocation);

		// Move to new position
		field.place(this, newLocation);
		field.place(null, oldLocation);
	}

}
