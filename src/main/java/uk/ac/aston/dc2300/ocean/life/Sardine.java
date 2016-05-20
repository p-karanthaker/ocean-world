package uk.ac.aston.dc2300.ocean.life;

public class Sardine extends Fish {

	public Sardine() {
		super(Species.SARDINE);
	}

	@Override
	public void eat(Creature creature) {
		// TODO Implement Sardine eating Plankton. Food Level will change in super-method.
		super.eat(creature);
	}
	
	@Override
	public void reproduce() {
		// TODO Create a baby Sardine? Super-method will set location?
		super.reproduce();
	}
	
}
