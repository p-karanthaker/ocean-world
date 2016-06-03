package uk.ac.aston.dc2300.ocean.world;

/**
 * ModelConstants holds all of the constants for the Ocean World simulation.
 * 
 * @author Karan Thaker / Orry Edwards
 *
 */
public class ModelConstants {

	/* Simulation Parameters */

	/**
	 * Length of simulation ticks
	 */
	public static int SIMULATION_LENGTH = 1000;

	/**
	 * The seed used in the Random Generator
	 */
	public static int RNG_SEED = 44;

	/**
	 * The width of the simulation field view
	 */
	public static int OCEAN_WIDTH = 100;

	/**
	 * The depth/height of the simulation field view
	 */
	public static int OCEAN_DEPTH = 100;

	/* Creature Parameters */

	/**
	 * Creation probability for Plankton.java
	 */
	public static double CREATION_ODDS_PLANKTON = 0.7f;

	/**
	 * Breeding probability for Plankton.java
	 */
	public static double BREEDING_ODDS_PLANKTON = 0.8f;

	/**
	 * Maximum age for Plankton.java
	 */
	public static int MAXIMUM_AGE_PLANKTON = 100;

	/**
	 * Breeding age for Plankton.java
	 */
	public static int BREEDING_AGE_PLANKTON = 0;

	/**
	 * Nutritional value for Plankton.java
	 */
	public static int NUTRITIONAL_VALUE_PLANKTON = 4;

	/**
	 * Creation probability for Sardine.java
	 */
	public static double CREATION_ODDS_SARDINE = 0.1f;

	/**
	 * Breeding probability for Sardine.java
	 */
	public static double BREEDING_ODDS_SARDINE = 0.5f;

	/**
	 * Maximum age for Sardine.java
	 */
	public static int MAXIMUM_AGE_SARDINE = 75;

	/**
	 * Breeding age for Sardine.java
	 */
	public static int BREEDING_AGE_SARDINE = 12;

	/**
	 * Nutritional value for Sardine.java
	 */
	public static int NUTRITIONAL_VALUE_SARDINE = 14;

	/**
	 * Creation probabilities for Shark.java
	 */
	public static double CREATION_ODDS_SHARK = 0.05f;

	/**
	 * Breeding probability for Shark.java
	 */
	public static double BREEDING_ODDS_SHARK = 0.2f;

	/**
	 * Maximum age for Shark.java
	 */
	public static int MAXIMUM_AGE_SHARK = 150;

	/**
	 * Breeding age for Shark.java
	 */
	public static int BREEDING_AGE_SHARK = 25;
}
