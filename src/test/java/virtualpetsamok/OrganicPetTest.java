package virtualpetsamok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrganicPetTest {

	OrganicPet underTest = new OrganicPet("Fido", "Black and White Pitty");
	OrganicPet underTest2 = new OrganicPet("Rey", "Scrappy puppo", 50, 80, 90);
	int tickTally = 51;
	int tickTally2 = 300;

	@Test
	public void shouldBeAbleToFeedOrganicPets() {
		int hungerBeforeFeeding = underTest2.getHunger();
		underTest2.feed();
		int hungerAfterFeeding = underTest2.getHunger();
		int impactOfFeeding = hungerAfterFeeding - hungerBeforeFeeding;
		assertTrue(impactOfFeeding > 0);

	}

	@Test
	public void shouldBeAbleToCreateOrganicPetWithAdditionalParameters() {
		int currenttHunger = underTest2.getHunger();
		int currenttThirst = underTest2.getThirst();
		int currentWasteUrgency = underTest2.getWasteUrgency();
		assertThat(currenttHunger, is(50));
		assertThat(currenttThirst, is(80));
		assertThat(currentWasteUrgency, is(90));

	}

	@Test
	public void shouldBeAbleToReturnDefaultHungerThirstBoredomIfNotSpecified() {
		int currenttHunger = underTest.getHunger();
		int currenttThirst = underTest.getThirst();
		int currentWasteUrgency = underTest.getWasteUrgency();
		assertThat(currenttHunger, is(100));
		assertThat(currenttThirst, is(100));
		assertThat(currentWasteUrgency, is(100));

	}

	@Test
	public void shouldBeAbleToWaterOrganicPets() {
		underTest2.water();
		int thirstAfterWatering = underTest2.getThirst();
		assertThat(thirstAfterWatering, is(100));

	}

	@Test
	public void shouldBeAbleToGeneratedWaste() {
		while (tickTally > 0) {
			underTest.tick();
			tickTally--;
		}
		int check = underTest.getWaste();
		assertThat(check, is(2));

	}

	@Test
	public void shouldBeAbleToCallTickAndSeeThirstImpactedBy2() {
		int thirstBeforeTick = underTest.getThirst();
		underTest.tick();
		int thirstAfterTick = underTest.getThirst();
		int check = thirstBeforeTick - thirstAfterTick;
		assertThat(check, is(2));
	}

	@Test
	public void zeroHungerShouldImpactHealth() {
		int healthCheckBeforeTicks = underTest.getHealth();
		while (tickTally > 0) {
			underTest.tick();
			tickTally--;
		}
		int healthCheckAfterTicks = underTest.getHealth();
		assertTrue(healthCheckAfterTicks < healthCheckBeforeTicks);
	}
	
	@Test
	public void zeroThirstShouldImpactHealth() {
		int healthCheckBeforeTicks = underTest.getHealth();
		while (tickTally > 0) {
			underTest.tick();
			tickTally--;
			underTest.feed();
		}
		int healthCheckAfterTicks = underTest.getHealth();
		assertTrue(healthCheckAfterTicks < healthCheckBeforeTicks);
	}
	
	@Test
	public void wasteBuildUpShouldImpactHealth() {
		int healthCheckBeforeTicks = underTest.getHealth();
		while (tickTally > 0) {
			underTest.tick();
			tickTally--;
			underTest.feed();
			underTest.water();
		}
		int healthCheckAfterTicks = underTest.getHealth();
		assertTrue(healthCheckAfterTicks < healthCheckBeforeTicks);
	}
	
	@Test
	public void shouldDieIfHealthReaches0() {
		while (tickTally2 > 0) {
			underTest.tick();
			tickTally2--;
		}
		assertFalse(underTest.getIsAlive());
	}
	
	

}
