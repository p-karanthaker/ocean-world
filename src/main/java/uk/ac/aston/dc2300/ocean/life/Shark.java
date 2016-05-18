package uk.ac.aston.dc2300.ocean.life;

public class Shark extends Fish {

	public Shark() {
		super(Species.SHARK);
	}

	@Override
	public void eat(Creature creature) {
		// TODO Implement Shark eating Sardine. Food Level will change in super-method.
		super.eat(creature);
	}
	
	@Override
	public void reproduce() {
		// TODO Create a baby Shark? Super-method will set location?
		super.reproduce();
	}
	
}
