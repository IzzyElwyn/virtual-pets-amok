package virtualpetsamok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RoboticPetTest {

	RoboticPet underTest = new RoboticPet("Sparky", "clunky metal dog");
	int tickTally = 51;

	@Test
	public void shouldBeAbleToOilRoboticPet() {
		underTest.tick();
		int oilBeforeOiling = underTest.getOilLevel();
		underTest.oil();
		int oilAfterOiling = underTest.getOilLevel();
		int oilLevelImpacted = oilAfterOiling - oilBeforeOiling;
		assertTrue(oilLevelImpacted > 0);
	}

	@Test
	public void shouldBeAbleToSpecifyAdditionalLevels() {
		RoboticPet underTest2 = new RoboticPet("K-9", "Hunky of scrappy scrap meta", 50);
		int oilCheck = underTest2.getOilLevel();
		assertThat(oilCheck, is(50));
	}

	@Test
	public void oilShouldBeImpactedByTick() {
		int oilBeforeTick = underTest.getOilLevel();
		underTest.tick();
		int oilAfterTick = underTest.getOilLevel();
		int check = (oilBeforeTick - oilAfterTick);
		assertThat(check, is(2));

	}

	@Test
	public void lowOilLevelShouldImpactHealth() {
		int healthCheckBeforeTick = underTest.getHealth();
		while (tickTally > 0) {
			underTest.tick();
			tickTally --;
		}
		int healthCheckAfterTick = underTest.getHealth();
		int check = (healthCheckBeforeTick - healthCheckAfterTick);
		assertTrue(check > 0);
	}
	
	@Test
	public void healthForRoboticTestShouldBeTiedToDustBuildUp() {
		int healthCheckBeforeTick = underTest.getHealth();
		while (tickTally > 0) {
		underTest.tick();
		underTest.oil();
		tickTally --;
		}
		int healthCheckAfterTick = underTest.getHealth();
		int check = (healthCheckBeforeTick - healthCheckAfterTick);
		assertTrue(check > 0);
	}
	
	@Test
	public void shouldBeAbleToDustRoboticPetsToClearDustBuildUp() {
		underTest.tick();
		int dustCheckBeforeDusting = underTest.getDustBuildUp();
		underTest.dustWithCompressedAir();
		int dustCheckAfterDusting = underTest.getDustBuildUp();
		assertTrue(dustCheckAfterDusting < dustCheckBeforeDusting);
		}
	
	
}
