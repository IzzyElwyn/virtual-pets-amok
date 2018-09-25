package virtualpetsamok;

public class OrganicPet extends VirtualPet {

	public static final int MAX_ORGANIC_PET_HUNGER = 100;
	private static final int MAX_ORGANIC_PET_THIRST = 100;
	protected static final int MAX_ORGANIC_PET_WASTEURGENCY = 100;
	private static final int MIN_ORGANIC_PET_WASTE = 0;
	private static final Boolean DEFAULT_ORGANIC_PET_ALIVE = true;

	public int hunger = MAX_ORGANIC_PET_HUNGER;
	private int thirst = MAX_ORGANIC_PET_THIRST;
	protected int wasteUrgency = MAX_ORGANIC_PET_WASTEURGENCY;
	private int waste = MIN_ORGANIC_PET_WASTE;
	private boolean isAlive = DEFAULT_ORGANIC_PET_ALIVE;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getWasteUrgency() {
		return wasteUrgency;
	}

	public int getWaste() {
		return waste;
	}

	public void setWaste(int wasteAmount) {
		waste = 0;

	}

	public boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public OrganicPet(String petName, String petDescription) {
		super(petName, petDescription);
	}

	public OrganicPet(String petName, String petDescription, int hunger, int thirst, int wasteUrgency) {
		super(petName, petDescription);
		this.hunger = hunger;
		this.thirst = thirst;
		this.wasteUrgency = wasteUrgency;
	}

	public void feed() {
		if (hunger + 25 > MAX_ORGANIC_PET_HUNGER) {
			hunger = MAX_ORGANIC_PET_HUNGER;
		} else {
			hunger += 25;
		}
	}

	public void water() {
		thirst = MAX_ORGANIC_PET_THIRST;
	}

	public void treatPet() {
		health = 100;

	}

	private void generateWasteCheck() {
		if (wasteUrgency == 0) {
			waste++;
			wasteUrgency = MAX_ORGANIC_PET_WASTEURGENCY;
		}

	}

	@Override
	public void tick() {
		if ((hunger - 2) < 0) {
			hunger = 0;
		} else {
			hunger -= 2;
		}
		if ((thirst - 2) < 0) {
			thirst = 0;
		} else {
			thirst -= 2;
		}
		if ((wasteUrgency - 2) < 0) {
			wasteUrgency = 0;
		} else {
			wasteUrgency -= 2;
		}

		generateWasteCheck();
		calculateHealthImpact();
	}

	@Override
	public void calculateHealthImpact() {
		if (hunger == 0) {
			if ((health - 5) < 0) {
				health = 0;
			} else {
				health -= 5;
			}
		}

		if (thirst == 0) {
			if ((health - 10) < 0) {
				health = 0;
			} else {
				health -= 10;
			}
		}
		if (waste > 0) {
			if ((health - (waste * 2)) < 0) {
				health = 0;
			} else {
				health -= (waste * 2);
			}
			if (health == 0) {
				dead();
			}
		}
	}

	private void dead() {
		setIsAlive(false);
	}

}
