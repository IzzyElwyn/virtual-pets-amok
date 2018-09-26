package virtualpetsamok;

public class RobotDog extends RoboticPet implements Walkable {

	public RobotDog(String petName, String petDescription) {
		super(petName, petDescription);

	}

	public RobotDog(String petName, String petDescription, int oilLevel) {
		super(petName, petDescription, oilLevel);

	}

	public void goForAWalk() {
		oilLevel -= 25;
		dustBuildUp = MIN_ROBOTICPET_DUST_BUILDUP;
	}

}
