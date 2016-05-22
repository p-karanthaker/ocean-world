package uk.ac.aston.dc2300.ocean.life;

import java.util.List;

import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

public class Shark extends Fish {

	public Shark(boolean isAgeZero, Location initialLocation) {
		super(Species.SHARK, isAgeZero, initialLocation);
	}

	@Override
	public void act(Field field) {
		//super.act(field);
	}

	@Override
	public void eatFood(List<Location> possibleFood, Field field){
        Creature creature = null;
        for(Location location : possibleFood)
        {
            creature = field.getObjectAt(location);
            
            if(creature.getSpecies() == Species.SARDINE){
                creature.setIsAlive(false);
                this.setFoodLevel(this.getFoodLevel() + 1);
                
                field.place(null, this.getLocation());
                this.setLocation(location);
                field.place(this, location);
                
                break;
            }
        }
    }
	
}
