package virtualpetsamok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VirtualPetTest {
	
	VirtualPet underTest = new VirtualPet("Spot", "Fluffy and cute");
	
	@Test
	public void shouldBeAbleToReturnNameAndDescriptionForVirtualPet() {
		String petName = underTest.getPetName();
		String petDesc = underTest.getPetDescription();
		assertThat(petName, is("Spot"));
		assertThat(petDesc, is("Fluffy and cute"));
	}
	
	@Test
	public void shouldBeAbleToCheckOnPetsHealth() {
		int petHealth = underTest.getHealth();
		assertThat(petHealth, is(100));
	}
	
	
}
