/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.aston.dc2300.ocean.life;

import uk.ac.aston.dc2300.ocean.world.Location;

/**
 *
 * @author OEDWARDS
 */
abstract public class CreatureFactory {

	/**
	 * Factory for creating creatures based on the species passed in
	 * 
	 * @param species
	 *            the species type of creature
	 * @param isAgeZero
	 *            if it is a creature as a result of breeding
	 * @param initialLocation
	 *            its first location
	 */
	public static Creature getCreature(Species species, boolean isAgeZero,
			Location initialLocation) {
		switch (species) {
		case PLANKTON:
			return new Plankton(isAgeZero, initialLocation);
		case SARDINE:
			return new Sardine(isAgeZero, initialLocation);
		case SHARK:
			return new Shark(isAgeZero, initialLocation);
		default:
			return null;
		}
	}
}
