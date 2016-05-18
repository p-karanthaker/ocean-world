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
public class CreatureFactory {
    
    public Creature getCreature(String species){
        if(species == null){
            return null;
        }
        else if(species == "Sardine"){
            return new Sardine(75, 12, 14, 0.1f, 0.5f);
        }
        else if(species == "Shark"){
            return new Shark(150, 25, 0, 0.05f, 0.2f);
        }
        else if(species == "Plankton"){
            return new Plankton(100, 0, 4, 0.7f, 0.8f);
        }
        
        return null;
    }
    
    public Creature getCreature(String species, int maxAge, int minBreedingAge, 
            int nutritionalValue, float creationOdds, float breedingOdds){
        if(species == null){
            return null;
        }
        else if(species == "Sardine"){
            return new Sardine(maxAge, minBreedingAge, nutritionalValue, 
                    creationOdds, breedingOdds);
        }
        else if(species == "Shark"){
            return new Shark(maxAge, minBreedingAge, nutritionalValue, 
                    creationOdds, breedingOdds);
        }
        else if(species == "Plankton"){
            return new Plankton(maxAge, minBreedingAge, nutritionalValue, 
                    creationOdds, breedingOdds);
        }
        
        return null;
    }
}
