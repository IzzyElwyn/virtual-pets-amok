package virtualpetsamok;

public class RoboticPet extends VirtualPet {


	private static final int MAX_ROBOTICPET_OIL_LEVEL = 100;
	protected static final int MIN_ROBOTICPET_DUST_BUILDUP = 0;
	private static final int DEFAULT_ROBOTICPET_DUST_BUNNIES = 0;


	protected int oilLevel = MAX_ROBOTICPET_OIL_LEVEL;
	protected int dustBuildUp = MIN_ROBOTICPET_DUST_BUILDUP;
	private int dustBunnies = DEFAULT_ROBOTICPET_DUST_BUNNIES;

	public int getOilLevel() {
		return oilLevel;
	}

	
	public int getDustBuildUp() {
		return dustBuildUp;
	}

	public RoboticPet(String petName, String petDescription) {
		super(petName, petDescription);
	}

	public RoboticPet(String petName, String petDescription, int oilLevel) {
		super(petName, petDescription);
		this.oilLevel = oilLevel;


	}

	public void oil() {
		oilLevel += 50;

	}

	public void dustWithCompressedAir() {
		dustBuildUp = 0;

	}

	private void generateDustBunnyCheck() {
		if (dustBuildUp == 100) {
			dustBunnies++;
			dustBuildUp = MIN_ROBOTICPET_DUST_BUILDUP;
		}

	}

	@Override
	public void tick() {

		if ((oilLevel - 2) < 0) {
			oilLevel = 0;
		} else {
			oilLevel -= 2;
		}
		if ((dustBuildUp + 2) > 100) {
			dustBuildUp = 100;
		} else {
			dustBuildUp += 2;
		}

		generateDustBunnyCheck();
		calculateHealthImpact();
	}

	@Override
	public void calculateHealthImpact() {
		if (oilLevel == 0) {
			if ((health - 2) < 0) {
				health = 0;
			} else {
				health -= 2;
			}
		}
		if (dustBunnies > 0) {
			if ((health - (dustBunnies * 2)) < 0) {
				health = 0;
			} else {
				health -= (dustBunnies * 2);
			}

		}
	}


	public void repairPet() {
		dustBunnies = 0;
		dustBuildUp = 0;
		health = 100;
		
	}



}
