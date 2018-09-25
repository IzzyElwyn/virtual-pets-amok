package virtualpetsamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> shelterPets = new HashMap<>();

	public void dropOffHomelessPet(VirtualPet pet) {
		shelterPets.put(pet.getPetName(), pet);

	}

	public VirtualPet getPet(String petName) {
		return shelterPets.get(petName);

	}

	public Collection<VirtualPet> getListOfPets() {
		return shelterPets.values();
	}

	public void adoptAPet(String petName) {
		shelterPets.remove(petName);

	}

	public void tick() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof OrganicPet) {
				((OrganicPet) shelterpet).tick();
			} else {
				((RoboticPet) shelterpet).tick();
			}
		}

	}

	public void feedPets() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof OrganicPet) {
				((OrganicPet) shelterpet).feed();

			}
		}
	}

	public void waterPets() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof OrganicPet) {
				((OrganicPet) shelterpet).water();
			}
		}

	}

	public void takePetToVet(String petName) {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof OrganicPet) {
				((OrganicPet) shelterpet).treatPet();
			} else {
				System.out.println("Please see the shelter Mechanic for treatment of Robotic Pets...");
			}
		}
	}

	public void takePetToMechanic(String petName) {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof RoboticPet) {
				((RoboticPet) shelterpet).repairPet();
			} else {
				System.out.println("Please see the shelter Veterinarian for treatment of Organic Pets...");
			}
		}

	}

	public int checkCagesForWaste() {
		int wasteCount = 0;
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof Dog) {
				wasteCount += ((Dog) shelterpet).getWaste();
			}
		}
		return wasteCount;
	}

	public void cleanShelterCages() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof Dog) {
				((OrganicPet) shelterpet).setWaste(0);
			}
		}
		
	}
}
