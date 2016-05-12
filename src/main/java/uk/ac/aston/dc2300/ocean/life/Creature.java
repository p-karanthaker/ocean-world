package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

/**
 * Creature class.
 * 
 * @author Karan Thaker
 *
 */
public class Creature {
	
	private String species;
	private int age;
	private int nutritionValue;
	private Location location;
	
	public Creature() {
		age = 0;
	}
	
	public Creature(String species) {
		this.species = species;
		age = 0;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public int getAge() {
		return age;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
