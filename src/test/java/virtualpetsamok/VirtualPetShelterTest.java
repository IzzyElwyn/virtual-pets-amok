package virtualpetsamok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest = new VirtualPetShelter();

	Dog dog = new Dog("Rey", "Black & White PitMix");
	Cat cat = new Cat("Crookshanks", "Orange cat with a squished face");
	RobotDog robodog = new RobotDog("K-9", "primitive hunk of metal that rolls around");
	RobotCat robocat = new RobotCat("Ripley", "a metal cat");
	int tickTimer = 50;

	@Test
	public void shouldBeAbleToDropOffAPet() {
		underTest.dropOffHomelessPet(dog);
		VirtualPet check = underTest.getPet("Rey");
		assertThat(check, is(dog));
	}

	@Test
	public void assertThatYouCanReturnACollectionOfPetsInTheShelter() {
		underTest.dropOffHomelessPet(dog);
		underTest.dropOffHomelessPet(robocat);
		Collection<?> animalList = underTest.getListOfPets();
		Collection<?> expectedResult = underTest.shelterPets.values();
		assertThat(animalList, is(expectedResult));
	}

	@Test
	public void shouldBeAbleToAdaptPet() {
		underTest.dropOffHomelessPet(dog);
		underTest.adoptAPet("Rey");
		Collection<?> animalList = underTest.getListOfPets();
		assertTrue(animalList.isEmpty());
	}

	@Test
	public void shouldBeAbleToOilRoboticPets() {
		underTest.dropOffHomelessPet(robodog);
		underTest.tick();
		int oilBeforeOiling = ((RoboticPet) underTest.getPet("K-9")).getOilLevel();
		underTest.oilPets();
		int oilAfterOiling = ((RoboticPet) underTest.getPet("K-9")).getOilLevel();
		int check = oilAfterOiling - oilBeforeOiling;
		assertThat(check, is(2));
	}

	@Test
	public void shouldBeAbleToFeedOrganicPets() {
		underTest.dropOffHomelessPet(dog);
		underTest.tick();
		int hungerBeforeFeeding = ((OrganicPet) underTest.getPet("Rey")).getHunger();
		underTest.feedPets();
		int hungerAfterFeeding = ((OrganicPet) underTest.getPet("Rey")).getHunger();
		int check = hungerAfterFeeding - hungerBeforeFeeding;
		assertThat(check, is(2));
	}

	@Test
	public void shouldBeAbleToWaterOrganicPets() {
		underTest.dropOffHomelessPet(dog);
		underTest.tick();
		int thirstBeforeWatering = ((OrganicPet) underTest.getPet("Rey")).getThirst();
		underTest.waterPets();
		int thirstAfterWatering = ((OrganicPet) underTest.getPet("Rey")).getThirst();
		int check = thirstAfterWatering - thirstBeforeWatering;
		assertThat(check, is(2));
	}

	@Test
	public void shouldBeAbleToTakeOrganicPetToVet() {
		underTest.dropOffHomelessPet(dog);
		tickTest();
		int healthCheckBeforeVet = underTest.getPet("Rey").getHealth();
		underTest.takePetToVet("Rey");
		int healthCheckAfterVet = underTest.getPet("Rey").getHealth();
		assertTrue(healthCheckAfterVet > healthCheckBeforeVet);

	}

	@Test
	public void shouldBeAbleToTakeRoboticPetToMechanic() {
		underTest.dropOffHomelessPet(robodog);
		tickTest();
		int healthCheckBeforeVet = underTest.getPet("K-9").getHealth();
		underTest.takePetToMechanic("K-9");
		int healthCheckAfterVet = underTest.getPet("K-9").getHealth();
		assertTrue(healthCheckAfterVet > healthCheckBeforeVet);

	}

	@Test
	public void shouldBeAbleToCleanWasteFromOrganicDogCages() {
		underTest.dropOffHomelessPet(dog);
		tickTest();
		int wasteBeforeCleaning = ((OrganicPet)underTest.getPet("Rey")).getWaste();
		underTest.cleanShelterCages();
		int wasteAfterCleaning = ((OrganicPet)underTest.getPet("Rey")).getWaste();
		assertTrue(wasteAfterCleaning < wasteBeforeCleaning);

	}

	@Test
	public void shouldBeAbleToCleanOutLitterBoxesForDaKitties() {
		underTest.dropOffHomelessPet(cat);
		tickTest();
		int wasteBeforeCleaning = ((OrganicPet)underTest.getPet("Crookshanks")).getWaste();
		underTest.cleanShelterLitterBoxes();
		int wasteAfterCleaning = ((OrganicPet)underTest.getPet("Crookshanks")).getWaste();
		assertTrue(wasteAfterCleaning < wasteBeforeCleaning);

	}

	@Test
	public void shouldBeAbleToPlayWithAPet() {
		underTest.dropOffHomelessPet(dog);
		String check = underTest.playWithAPet("Rey");
		assertThat(check, is("You played with Rey!"));
	}

	@Test
	public void shouldBeAbleToPlayWithAPetAndAdverselyAffectThirstForOrganics() {
		underTest.dropOffHomelessPet(dog);
		int thirstBeforePlaying = ((OrganicPet) underTest.getPet("Rey")).getThirst();
		underTest.playWithAPet("Rey");
		int thirstAfterPlaying = ((OrganicPet) underTest.getPet("Rey")).getThirst();
		assertTrue(thirstBeforePlaying > thirstAfterPlaying);
	}

	@Test
	public void shouldBeAbleToPlayWithAPetAndPositivelyImpactDustForRobotics() {
		underTest.dropOffHomelessPet(robocat);
		underTest.tick();
		int dustBeforePlaying = ((RoboticPet) underTest.getPet("Ripley")).getDustBuildUp();
		underTest.playWithAPet("Ripley");
		int dustAfterPlaying = ((RoboticPet) underTest.getPet("Ripley")).getDustBuildUp();
		assertTrue(dustAfterPlaying < dustBeforePlaying);
	}

	private void tickTest() {
		while (tickTimer > 0) {
			underTest.tick();
			tickTimer--;
		}
	}

}
