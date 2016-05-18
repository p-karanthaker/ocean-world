package uk.ac.aston.dc2300.ocean.world;

import java.util.Random;


class RandomGenerator {
	private static Random random=null;   
	private static int seed= ModelConstants.RNG_SEED;

	public static void initialiseWithSeed(int s){
		seed = s;
		random = new Random(seed);
	}
	
	public static Random getRandom(){
		if(random==null){
			random = new Random(seed);
		}
		return random;
	}	
}
