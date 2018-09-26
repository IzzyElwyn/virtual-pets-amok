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

	public String playWithAPet(String petName) {
		for (VirtualPet shelterpet : shelterPets.values()) {
			shelterpet.play();
		}
		return "You played with " + petName + "!";
	}

	public Collection<VirtualPet> getListOfPets() {
		return shelterPets.values();
	}

	public void adoptAPet(String petName) {
		shelterPets.remove(petName);
	}

	public void tick() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			shelterpet.tick();
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

	public void oilPets() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof RoboticPet) {
				((RoboticPet) shelterpet).oil();
			}
		}
	}

	public void takePetToVet(String petName) {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof OrganicPet && shelterpet.getPetName().equalsIgnoreCase(petName)) {
				((OrganicPet) shelterpet).treatPet();
			} else {
				System.out.println("Please see the shelter Mechanic for treatment of Robotic Pets...");
			}
		}
	}

	public void takePetToMechanic(String petName) {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof RoboticPet && shelterpet.getPetName().equalsIgnoreCase(petName)) {
				((RoboticPet) shelterpet).repairPet();
			} else {
				System.out.println("Please see the shelter Veterinarian for treatment of Organic Pets...");
			}
		}
	}

	public void cleanShelterCages() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof Dog) {
				((Dog) shelterpet).setWaste(0);
			}
		}
	}

	public void cleanShelterLitterBoxes() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof Cat) {
				((Cat) shelterpet).setWaste(0);
			}
		}
	}

	public void dustRoboticPets() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof RoboticPet) {
				((RoboticPet) shelterpet).dustWithCompressedAir();
			}
		}
	}
	
	public boolean deadPetCheck() {
		for (VirtualPet shelterpet : shelterPets.values()) {
			if (shelterpet instanceof OrganicPet) {
				if (!((OrganicPet) shelterpet).getIsAlive()) {
					return true;
					
				} 
			
			} 
		} return false; 
	}
}
