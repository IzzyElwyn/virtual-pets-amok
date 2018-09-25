package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RobotDogTest {
	
	RobotDog underTest = new RobotDog("K-9", "Chunky Robo Dog");
	
	@Test
	public void shouldBeAbleToWalkRobotDog() {
	int oilBeforeWalk = underTest.getOilLevel();
	underTest.goForAWalk();
	int oilAfterWalk = underTest.getOilLevel();
	assertTrue(oilAfterWalk < oilBeforeWalk);
	}
	
	@Test
	public void shouldSeeDustBuildUpAfterTick() {
		underTest.tick();
		int check = underTest.getDustBuildUp();
		assertTrue(check > 0);
	}
	
	@Test
	public void shouldSeeDustBuildUpResetAfterWalk() {
		underTest.tick();
		int dustCheckBeforeWalk = underTest.getDustBuildUp();
		underTest.goForAWalk();
		int dustCheckAfterWalk = underTest.getDustBuildUp();
		assertTrue(dustCheckAfterWalk < dustCheckBeforeWalk);
	}
}
