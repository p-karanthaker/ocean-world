package uk.ac.aston.dc2300.ocean.world;

public class ModelConstants {

	/* Simulation Parameters */
	public static int SIMULATION_LENGTH = 1000;
	public static int RNG_SEED = 44;
	public static int OCEAN_WIDTH = 100;
	public static int OCEAN_DEPTH = 100;
	
	/* Creature Parameters */
		// Plankton
	public static float CREATION_ODDS_PLANKTON;
	public static float BREEDING_ODDS_PLANKTON;
	public static int MAXIMUM_AGE_PLANKTON;
	public static int BREEDING_AGE_PLANKTON;
	public static int NUTRITIONAL_VALUE_PLANKTON;
	
		// Sardine
	public static float CREATION_ODDS_SARDINE;
	public static float BREEDING_ODDS_SARDINE;
	public static int MAXIMUM_AGE_SARDINE;
	public static int BREEDING_AGE_SARDINE;
	public static int NUTRITIONAL_VALUE_SARDINE;
	
		// Shark
	public static float CREATION_ODDS_SHARK;
	public static float BREEDING_ODDS_SHARK;
	public static int MAXIMUM_AGE_SHARK;
	public static int BREEDING_AGE_SHARK;
}
