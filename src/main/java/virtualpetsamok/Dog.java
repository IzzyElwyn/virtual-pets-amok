package virtualpetsamok;

public class Dog extends OrganicPet implements Walkable  {

	public Dog(String petName, String petDescription) {
		super(petName, petDescription);

	}

	public Dog(String petName, String petDescription, int hunger, int thirst, int wasteUrgency) {
		super(petName, petDescription, hunger, thirst, wasteUrgency);

	}

	@Override
	public void goForAWalk() {
		wasteUrgency = MAX_ORGANIC_PET_WASTEURGENCY;
	}





}
