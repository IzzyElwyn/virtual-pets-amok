package virtualpetsamok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DogTest {

	Dog underTest = new Dog("Rey", "Scrappy pupper", 50, 60, 50);
	
	
	@Test
	public void shouldBeAbleToFeedDog() {
		int hungerBeforeFeeding = underTest.getHunger();
		underTest.feed();
		int hungerAfterFeeding = underTest.getHunger();
		int impactOfFeeding = hungerAfterFeeding - hungerBeforeFeeding;
		assertTrue(impactOfFeeding > 0);
			
		}
	
	@Test
	public void shouldBeAbleToWalkDogAndResetWasteUrgency() {
		underTest.goForAWalk();
		int check = underTest.getWasteUrgency();
		assertTrue(check == 100);
	}
	@Test
	public void shouldBeAbleToImpactHungerAfterTick() {
		int hungerBeforeTick = underTest.getHunger();
		underTest.tick();
		int hungerAfterTick = underTest.getHunger();
		int check = hungerBeforeTick - hungerAfterTick;
		assertThat(check, is(2));
	}
	

}
