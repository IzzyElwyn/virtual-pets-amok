package virtualpetsamok;

public class Cat extends OrganicPet {

	public Cat(String petName, String petDescription) {
		super(petName, petDescription);

	}

	public Cat(String petName, String petDescription, int hunger, int thirst, int wasteUrgency) {
		super(petName, petDescription, hunger, thirst, wasteUrgency);
	}

}
