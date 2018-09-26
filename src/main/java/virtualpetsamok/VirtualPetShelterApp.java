package virtualpetsamok;

import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {


	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean deadPets = false;
		int userOption;
		int dropOffType;


		VirtualPetShelter shelter = new VirtualPetShelter();

		Cat jonesy = new Cat("Jonesy", "Orange Tabby Cat", 85, 75, 95);
		Dog sirius = new Dog("Sirius", "Large, scruffy black dog", 93, 74, 98);
		RobotDog k9 = new RobotDog("K-9", "A cluncky rolly robo dog", 45);
		RobotCat hershey = new RobotCat("Floof", "Black and White robo kitty", 87);

		shelter.dropOffHomelessPet(jonesy);
		shelter.dropOffHomelessPet(sirius);
		shelter.dropOffHomelessPet(k9);
		shelter.dropOffHomelessPet(hershey);

		Collection<VirtualPet> pets = shelter.getListOfPets();

		System.out.println("Welcome to the Robo/Organic Virtual Pet Shelter");

		do {
			System.out.println("Our current residents are:\n");
			ShelterMenus.roboPetStats(pets);
			ShelterMenus.organicPetStats(pets);

			ShelterMenus.mainMenu();
			userOption = input.nextInt();
			input.nextLine();

			switch (userOption) {
			case 1:
				ShelterMenus.feedWaterSubMenu();
				int foodSubMenuChoice = input.nextInt();
				input.nextLine();

				if (foodSubMenuChoice == 1) {
					shelter.feedPets();
					System.out.println("You fed all the organic pets!");
				} else if (foodSubMenuChoice == 2) {
					shelter.waterPets();
					System.out.println("You watered all the organic pets!");
				}
				break;
			case 2:
				shelter.oilPets();
				System.out.println("You oiled all the mechanical pets!");
				break;
			case 3:
				ShelterMenus.cleanSubMenu();
				int cleanSubMenuChoice = input.nextInt();
				input.nextLine();

				if (cleanSubMenuChoice == 1) {
					shelter.cleanShelterCages();
					System.out.println("You cleaned all the organic dog cages!");
				} else if (cleanSubMenuChoice == 2) {
					shelter.cleanShelterLitterBoxes();
					System.out.println("You cleaned all the organic cat litterboxes!");
				} else if (cleanSubMenuChoice == 3) {
					shelter.dustRoboticPets();
					System.out.println("You dusted all the mechanical pets with compressed air!");
				}
				break;
			case 4:
				ShelterMenus.careSubMenu();
				int careSubMenuChoice = input.nextInt();
				input.nextLine();
				
				if (careSubMenuChoice == 1) {
					System.out.println("Which pet would you like to take to the Mechanic?");
					ShelterMenus.roboPetStats(pets);
					String choice = input.nextLine();
					shelter.takePetToMechanic(choice);
					System.out.println("The shelter mechanic fixed " + choice + " up!");
				} else if (careSubMenuChoice == 2) {
					System.out.println("Which pet would you like to take to the Vet?");
					ShelterMenus.organicPetStats(pets);
					String choice = input.nextLine();
					shelter.takePetToVet(choice);
					System.out.println("The shelter vet treated " + choice + " but says to be more diligent with feeding, watering and cleaning their cages!");
				}
				break;
			case 5:
				ShelterMenus.adoptOrDropSubMenu();
				int optionsSubMenuChoice = input.nextInt();
				input.nextLine();
				
				if (optionsSubMenuChoice == 1) {
					System.out.println("Which pet would you like to adopt?");
					for (VirtualPet pet : pets) {
						System.out.println(pet.getPetName() + ": " + pet.getPetDescription());
					}
					String adoptedPet = input.nextLine();
					shelter.adoptAPet(adoptedPet);
				} else if (optionsSubMenuChoice == 2) {
					do {
					System.out.println("What type of pet is being dropped off?");
					ShelterMenus.dropOffSubMenu();
					dropOffType = input.nextInt();
					input.nextLine();
					}
					while (dropOffType > 4 || dropOffType < 1);
					System.out.println("And what is the name of the pet being dropped off?");
					String petName = input.nextLine();
					System.out.println("Please provide a short description of the pet being dropped off:");
					String petDescription = input.nextLine();
					VirtualPet admittedPet = null;
					if (dropOffType == 1) {
						admittedPet = new Dog(petName, petDescription);
					} else if (dropOffType == 2) {
						admittedPet = new Cat(petName, petDescription);
					} else if (dropOffType == 3) {
						admittedPet = new RobotDog(petName, petDescription);
					} else if (dropOffType == 4) {
						admittedPet = new RobotCat(petName, petDescription);
					}
					shelter.dropOffHomelessPet(admittedPet);
				}
				
				break;
			case 6:
				System.out.println("Which pet would you like to play with?");
				for (VirtualPet pet : pets) {
					System.out.println(pet.getPetName() + ": " + pet.getPetDescription());
				}
				String playWithPet = input.nextLine();
				shelter.playWithAPet(playWithPet);
				break;
			default:
				System.out.println(" ");
			}

			shelter.tick();
			deadPets = shelter.deadPetCheck();

		} while (userOption != 0 && !deadPets);

		if (userOption == 0) {
		System.out.println("We appreciate your help with our unusual critters.");
		System.out.println("Have a great day");
		System.exit(0);
		} else {
			System.out.println("Neglecting a pet to death is not cool, man... ");
		System.exit(0);
		}

		input.close();
	}

}
