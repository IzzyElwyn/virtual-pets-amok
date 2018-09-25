package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CatTest {
	
	Cat underTest = new Cat("Fluffy", "Orange Tabby");

	@Test
	public void shouldGetHungryAfterTicket() {
		int hungerBeforeTick = underTest.getHunger();
		underTest.tick();
		int hungerAfterTick = underTest.getHunger();
		assertTrue(hungerAfterTick < hungerBeforeTick);
	}
}
