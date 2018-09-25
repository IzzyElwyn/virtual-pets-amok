package virtualpetsamok;

public class VirtualPet {

	private static final int DEFAULT_PET_HEALTH = 100;
	protected int health = DEFAULT_PET_HEALTH;
	
	private String petDescription;
	private String petName;

	public String getPetName() {
		return petName;
	}

	public String getPetDescription() {
		return petDescription;
	}

	public VirtualPet(String petName, String petDescription) {
		this.petName = petName;
		this.petDescription = petDescription;
	}

	public int getHealth() {
		return health ;
	}
	
	public void calculateHealthImpact() {
		
	}
	
	public void tick() {
		
	}


}
