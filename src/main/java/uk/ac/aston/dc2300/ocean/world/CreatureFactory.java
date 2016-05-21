/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.aston.dc2300.ocean.world;

import uk.ac.aston.dc2300.ocean.life.*;
/**
 *
 * @author OEDWARDS
 */
abstract public class CreatureFactory {
    
    public static Creature getCreature(Species species, Location initialLocation){
    	switch (species) {
	    	case PLANKTON:
	    		return new Plankton(initialLocation);
	    	case SARDINE:
	    		return new Sardine(initialLocation);
	    	case SHARK:
	    		return new Shark(initialLocation);
	    	default:
	    		return null;
    	}
    }
}
