package virtualpetsamok;

import java.util.Collection;

public class ShelterMenus {

	public static void mainMenu() {
		System.out.println("What would you like to do?\n\n" 
				+ "Press 1 to feed or water organic pets\n"
				+ "Press 2 to oil robotic pets\n" 
				+ "Press 3 to clean up\n" 
				+ "Press 4 to care for sick pets\n"
				+ "Press 5 to adopt or drop off a pet\n" 
				+ "Press 6 to play with a pet\n" 
				+ "Press 7 to do nothing\n"
				+ "Press 0 to exit\n");
	}

	public static void cleanSubMenu() {
		System.out.println("\nWhat would you like to do?\n"
				+ "\nPress 1 to clean organic dog cages"
				+ "\nPress 2 to clean organic cat litterboxes"
				+ "\nPress 3 to dust all robotic pets"
				+ "\nPress 4 to return to the main menu");
	}
	
	public static void feedWaterSubMenu() {
		System.out.println("\nWhat would you like to do?\n"
				+ "\nPress 1 to feed all organic pets"
				+ "\nPress 2 to water all organic pets"
				+ "\nPress 3 to return to the main menu");
	}
	
	public static void careSubMenu() {
		System.out.println("\nWhat would you like to do?\n"
				+ "\nPress 1 to take a pet to the Mechanic"
				+ "\nPress 2 to take a pet to the Vet"
				+ "\nPress 3 to return to the main menu");
	}
	
	public static void adoptOrDropSubMenu() {
		System.out.println("\nWhat would you like to do?\n"
				+ "\nPress 1 to adopt a pet"
				+ "\nPress 2 to drop off a new pet at the shelter"
				+ "\nPress 3 to return to the main menu");
	}
	
	public static void dropOffSubMenu() {
		System.out.println("\nPress 1 for Organic Dog"
				+ "\nPress 2 for Organic Cat"
				+ "\nPress 3 for Robotic Dog"
				+ "\nPress 4 for Robotic Cat");
	}
	
	
	public static void roboPetStats(Collection<VirtualPet> roboPets) {
		System.out.println("Robotic Pets");
		System.out.println("Type\t|Name\t|Oil\t|Dust\t|Health");
		System.out.println("--------|-------|-------|-------|-------");
		for (VirtualPet pet : roboPets) {
			if (pet instanceof RobotDog) {
				System.out.println("Dog" + "\t|" + pet.getPetName() + "\t|" + ((RoboticPet) pet).getOilLevel() + "\t|"
						+ ((RoboticPet) pet).getDustBuildUp() + "\t|" + pet.getHealth());
			} else if (pet instanceof RobotCat) {
				System.out.println("Cat" + "\t|" + pet.getPetName() + "\t|" + ((RoboticPet) pet).getOilLevel() + "\t|"
						+ ((RoboticPet) pet).getDustBuildUp() + "\t|" + pet.getHealth());
			}
		}
		System.out.println(" ");

	}

	public static void organicPetStats(Collection<VirtualPet> orgPets) {
		System.out.println("Organic Pets");
		System.out.println("Type\t|Name\t|Hunger\t|Thirst\t|Waste\t|Health");
		System.out.println("--------|-------|-------|-------|-------|-------|");
		for (VirtualPet pet : orgPets) {
			if (pet instanceof Dog) {
				System.out.println("Dog" + "\t|" + pet.getPetName() + "\t|" + ((OrganicPet) pet).getHunger() + "\t|"
						+ ((OrganicPet) pet).getThirst() + "\t|" + ((OrganicPet) pet).getWaste() + "\t|"
						+ pet.getHealth());
			} else if (pet instanceof Cat) {
				System.out.println("Cat" + "\t|" + pet.getPetName() + "\t|" + ((OrganicPet) pet).getHunger() + "\t|"
						+ ((OrganicPet) pet).getThirst() + "\t|" + ((OrganicPet) pet).getWaste() + "\t|"
						+ pet.getHealth());
			}
		}
		System.out.println(" ");
	}
}
