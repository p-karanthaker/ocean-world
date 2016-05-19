package uk.ac.aston.dc2300.ocean.world;

public class ModelConstants {

	/* Simulation Parameters */
	public static int SIMULATION_LENGTH = 1000;
	public static int RNG_SEED = 44;
	public static int OCEAN_WIDTH = 100;
	public static int OCEAN_DEPTH = 100;
	
	/* Creature Parameters */
		// Plankton
	public static float CREATION_ODDS_PLANKTON = 0.7f;
	public static float BREEDING_ODDS_PLANKTON = 0.8f;
	public static int MAXIMUM_AGE_PLANKTON = 100;
	public static int BREEDING_AGE_PLANKTON = 0;
	public static int NUTRITIONAL_VALUE_PLANKTON = 4;
	
		// Sardine
	public static float CREATION_ODDS_SARDINE = 0.1f;
	public static float BREEDING_ODDS_SARDINE = 0.5f;
	public static int MAXIMUM_AGE_SARDINE = 75;
	public static int BREEDING_AGE_SARDINE = 12;
	public static int NUTRITIONAL_VALUE_SARDINE = 14;
	
		// Shark
	public static float CREATION_ODDS_SHARK = 0.05f;
	public static float BREEDING_ODDS_SHARK = 0.2f;
	public static int MAXIMUM_AGE_SHARK = 150;
	public static int BREEDING_AGE_SHARK = 25;
}
