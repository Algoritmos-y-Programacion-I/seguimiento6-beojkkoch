package ui;

import java.util.Scanner;

import model.Fauna;
import model.SpeciesController;
import model.SpeciesTypeFlora;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("\nWelcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("4. Show Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 1:
				registerSpecies();
				break;
			case 2:
				editSpecies();
				break;
			case 3:
				deleteSpecies();
				break;
			case 4:
				showSpecies();
			case 0:
				System.out.println("Thanks for using our system");
				stopFlag = true;
				break;
			default:
				System.out.println("You must type a valid option");
				break;

			}

		}

	}


	/*
	 * Description: REGISTER SPECIES
	 */
	public void registerSpecies() {

		System.out.println("Type Specie \n  1. Fauna \n  2. Flora");
		int typeSpecie = reader.nextInt();
		reader.nextLine();

		switch (typeSpecie) {
			case 1:
				System.out.println("Type the new Species' name: ");
				String nameFauna = reader.nextLine();

				System.out.println("Type the new Species' scientific name: ");
				String scientificNameFauna = reader.nextLine();

				System.out.println("Type the new Species' migratory: Yes / No");
				String migratory = reader.nextLine();

				System.out.println("Maximum Weight': (only numbers, in  kg)");
				double maxWeight = reader.nextDouble();
				reader.nextLine();

				int typeFauna;
				do{
					System.out.println("Type': \n 1. BIRD \n 2. MAMMAL \n 3. AQUATIC FAUNA");
					typeFauna = reader.nextInt();

					if(typeFauna>3  || typeFauna<1){
						System.out.println("Please enter a valid option");
					}
				}while(typeFauna>3  || typeFauna<1);


				if (speciesController.registerSpeciesFauna(nameFauna, scientificNameFauna,  migratory,  maxWeight, typeFauna)) {
					System.out.println("Species registered successfully");
				} else {
					System.out.println("Error, Species couldn't be registered");
				}
				break;

			case 2:
				System.out.println("Type the new Species' name: ");
				String nameFlora = reader.nextLine();

				System.out.println("Type the new Species' scientific name: ");
				String scientificNameFlora = reader.nextLine();

				System.out.println("The specie has flowers:  Yes / No");
				String flowers = reader.nextLine();

				System.out.println("The especie has fruits?'  Yes / No");
				String fruits = reader.nextLine();

				System.out.println("'What is the height?: (only numbers in meters)");
				double maxHeight = reader.nextDouble();
				reader.nextLine();

				
				int typeFlora;
				do{
					System.out.println("Type': \n  1. LAND FLORA \n  2. AQUATIC_FLORA");
					typeFlora = reader.nextInt();
					reader.nextLine();

					if(typeFlora>2 || typeFlora<1){
						System.out.println("Please enter a valid option");
					}
				}while(typeFlora>3  || typeFlora<1);


				if (speciesController.registerSpeciesFlora(nameFlora, scientificNameFlora,  flowers,  fruits, maxHeight, typeFlora)) {
					System.out.println("Species registered successfully");
				} else {
					System.out.println("Error, Species couldn't be registered");
				}
				break;

			default:
				System.out.println("error");
				break;
			}
		}


	/*
	 * Description: MODIFY SPECIES
	 */
	public void editSpecies() {
		
		System.out.println("Type Specie to edit \n  1. Fauna \n  2. Flora");
		int typeSpecie = reader.nextInt();
		reader.nextLine();

		switch (typeSpecie) {

			case 1:
				System.out.println("Which Species do you want to edit?");

				String query = speciesController.showSpeciesListFauna();
				if (!query.equals("")) {
					System.out.println(query);
					editSpecieFauna();
				} else {
					System.out.println("There aren't any species registered yet");
				}
				break;

			case 2:
				System.out.println("Which Species do you want to edit?");
				
				String cosult = speciesController.showSpeciesListFlora();
				if (!cosult.equals("")) {
					System.out.println(cosult);
					editSpecieFlora();
					
				} else {
					System.out.println("There aren't any species registered yet");
				}
				break;

			default:
				System.out.println("error");
				break;
		}
		
	}


	public void editSpecieFauna(){

		System.out.println("\nSpecie to edit:");
		String nameFauna = reader.nextLine();

		System.out.println("Enter the data for the Fauna species:");

        System.out.print(" New Name: ");
        String newName = reader.nextLine(); 

        System.out.print(" New Scientific Name: ");
        String newScientificName = reader.nextLine();  

        System.out.print(" Is it migratory? (true/false): ");
        String newMigratory = reader.nextLine();  

        System.out.print(" New Max weight (in kg): ");
        double newMaxWeight = reader.nextDouble();
		reader.nextLine();

		System.out.print(" New type : \n 1. BIRD \n  2. MAMMAL \n 3. AQUATIC FAUNA");
        int typeFauna = reader.nextInt();
		reader.nextLine();

		boolean result = speciesController.searchAndEditFauna(nameFauna, newName, newScientificName,  newMigratory,  newMaxWeight, typeFauna);
        
            if (result) {
                System.out.println("Fauna species registered successfully.");
            }else{
				System.out.println("Unable to register more fauna species, the array is full.");
			}
        }
        
	


	public void editSpecieFlora(){
		System.out.println("Specie to edit");
		String nameFlora = reader.nextLine();

		System.out.println("Enter the data for the Fauna species:");

        System.out.print(" New Name: ");
        String newName = reader.nextLine(); 

        System.out.print(" New Scientific Name: ");
        String newScientificName = reader.nextLine();  

        System.out.print(" It has flowers? (yes/No): ");
        String newflowers = reader.nextLine();  

        System.out.print(" It has fruits? (yes/No): ");
        String newfruits = reader.nextLine(); 

		System.out.print(" New  max height (only numbers): ");
		double newMaxHeight = reader.nextDouble();
		reader.nextLine();

		System.out.print(" New type :  \\n" + 
						"  1. LAND FLORA \\n" + 
						"  2. AQUATIC_FLORA ");
        int newTypeFlora = reader.nextInt();
		reader.nextLine();
		
		

		boolean result = speciesController.searchAndEditFlora(nameFlora, newName, newScientificName,  newflowers,  newfruits, newMaxHeight, newTypeFlora);
        
            if (result) {
                System.out.println("Fauna species registered successfully.");
            }else{
				System.out.println("Unable to register more fauna species, the array is full.");
			}
        }



	 /*
	 * Description: DELETE SPECIES
	 */
	public void deleteSpecies() {
		
		System.out.println("\n\nType Specie to delete \n  1. Fauna \n  2. Flora");
		int typeSpecie = reader.nextInt();
		reader.nextLine();

		switch (typeSpecie) {

			case 1:
				System.out.println("Which Species do you want to delete?");

				String query = speciesController.showSpeciesListFauna();
				if (!query.equals("")) {
					System.out.println(query);
					System.out.println("Specie to delete:");
					String nameFauna = reader.nextLine();
					boolean deleteFauna = speciesController.deleteFauna(nameFauna);
					if(deleteFauna){
						System.out.println("This specie " +nameFauna+ " do not exist");
					}else{
						System.out.println("Specie delete successfull");
					}	
				} else {
					System.out.println("There aren't any species registered yet");
				}
				break;

			case 2:
				System.out.println("Which Species do you want to delete?");

				String cosult = speciesController.showSpeciesListFlora();
				if (!cosult.equals("")) {
					System.out.println(cosult);
					System.out.println("Specie to delete:");
					String nameFlora = reader.nextLine();
					boolean deleteFauna = speciesController.deleteFlora(nameFlora);
					if(deleteFauna){
						System.out.println("Specie delete successfull");
					}else{
						System.out.println("This specie " +nameFlora+ " do not exist ");
					}
				} else {
					System.out.println("There aren't any species registered yet");
				}
				break;

			default:
				System.out.println("error");
				break;
		}
	}




	/*
	 * Description: CONSULT SPECIES
	 */
	public void showSpecies() {

		boolean validOption = false;
    
		
		while (!validOption) {
			System.out.println("Which Species do you want to review? \n  1. Fauna \n  2. Flora");
			int typeSpecie = reader.nextInt();
			reader.nextLine();
	
			if (typeSpecie < 1 || typeSpecie > 2) {
				System.out.println("Please enter a valid option");
			} else {
				
				if (typeSpecie == 1) {
					String query = speciesController.showSpeciesListFauna();
					if (!query.equals("")) {
						System.out.println(query);
					} else {
						System.out.println("There aren't any species registered yet");
						
						
					}
				}
	
				
				if (typeSpecie == 2) {
					String queryTwo = speciesController.showSpeciesListFlora(); 
					if (!queryTwo.equals("")) {
						System.out.println(queryTwo);
					} else {
						System.out.println("There aren't any species registered yet");
					}
				}
	
				validOption = true;
				showMainMenu();
			}
		}
	}
}
