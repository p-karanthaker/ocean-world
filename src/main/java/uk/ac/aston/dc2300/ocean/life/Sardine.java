package uk.ac.aston.dc2300.ocean.life;

import com.sun.media.sound.ModelAbstractChannelMixer;
import java.util.List;
import uk.ac.aston.dc2300.ocean.world.Field;
import uk.ac.aston.dc2300.ocean.world.Location;

public class Sardine extends Fish {

	public Sardine(boolean isAgeZero, Location initialLocation) {
		super(Species.SARDINE, isAgeZero, initialLocation);
	}

	@Override
	public void act(Field field) {
		super.act(field);
	}
        
        public void eatFood(List<Location> possibleFood, Field field){
            Creature creature = null;
            for(Location location : possibleFood)
            {
                creature = field.getObjectAt(location);
                
                if(creature.getSpecies() == Species.PLANKTON){
                    creature.setIsAlive(false);
                    this.setLocation(location);
                    this.setFoodLevel(this.getFoodLevel() + 1);
                }
            }
        }
	
}
