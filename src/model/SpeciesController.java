package model;

public class SpeciesController {

	private Fauna[] fauna;
	private Flora[] flora;

	public SpeciesController() {

		this.fauna = new Fauna[80];
		this.flora = new Flora[80];

	}


	public boolean registerSpeciesFauna(String nameFauna, String scientificNameFauna, String migratory, double maxWeight, int typeFauna) {

		SpeciesTypeFauna type = SpeciesTypeFauna.BIRD;
		switch(typeFauna) {
			case 1:
				type = SpeciesTypeFauna.BIRD;
				break;
			case 2:
				type = SpeciesTypeFauna.MAMMAL;
				break;
			case 3:
				type = SpeciesTypeFauna.AQUATIC_FAUNA;
				break;
			default:
				type = SpeciesTypeFauna.MAMMAL;
				break;
		}

		for (int i = 0; i < fauna.length; i++) {
			if (fauna[i] == null) {
				fauna[i] = new Fauna( nameFauna, scientificNameFauna, migratory, maxWeight, type);
				return true;
			}
		}
		return false;
	}



	public boolean registerSpeciesFlora(String name, String scientificName, String flowers, String fruits, double maxHeight, int typeFlora) {

		SpeciesTypeFlora type = SpeciesTypeFlora.AQUATIC_FLORA;
		switch(typeFlora) {
			case 1:
				type = SpeciesTypeFlora.AQUATIC_FLORA;
				break;
			case 2:
				type = SpeciesTypeFlora.LAND_FLORA;
				break;
			default:
				type = SpeciesTypeFlora.LAND_FLORA;
				break;
		}

		for (int i = 0; i < flora.length; i++) {
			if (flora[i] == null) {
				flora[i] = new Flora(name,  scientificName,  flowers,  fruits,  maxHeight, type);
				return true;
			}
		}
		return false;
	}


	public String showSpeciesListFauna() {
		String msg = "";
		for (int i = 0; (i < fauna.length); i++) {
			if (fauna[i] != null) {
				msg += fauna[i].toString();
			}
		}
		return msg;
	}


	public String showSpeciesListFlora(){
		String msg = "";
		for (int i = 0; (i < flora.length); i++) {
			if (flora[i] != null) {
				msg += flora[i].toString();
			}
		}
		return msg;
	}



	public boolean deleteFauna(String nameFauna){

		for(int i=0; i<fauna.length; i++){
            if(fauna[i]!=null && fauna[i].getName().equalsIgnoreCase(nameFauna)){
                fauna[i] = null;
                return true;
            }
        }
        return false;
    } 



	public boolean deleteFlora(String nameFlora){

		for(int i=0; i<flora.length; i++){
            if(flora[i]!=null && flora[i].getName().equals(nameFlora)){
                flora[i] = null;
                return true;
            }
        }
        return false;
    } 


	public boolean searchAndEditFauna(String nameFauna, String newName, String newScientificName, String newMigratory, double newMaxWeight, int typeFauna){
		for(int i=0; i < fauna.length; i++){
			if(fauna[i] != null && fauna[i].getName().equalsIgnoreCase(nameFauna)){
				fauna[i].setName(newName);
				fauna[i].setScientificName(newScientificName);
				fauna[i].setMigratory(newMigratory);
				fauna[i].setMaxWeight(newMaxWeight);


				SpeciesTypeFauna newTypeFauna;
				switch(typeFauna){
					case 1:
						newTypeFauna = SpeciesTypeFauna.AQUATIC_FAUNA;
					break;
					case 2:
						newTypeFauna =  SpeciesTypeFauna.BIRD;
						break;
					case 3:
						newTypeFauna  = SpeciesTypeFauna.MAMMAL;
						break;
					default:
						newTypeFauna =  SpeciesTypeFauna.MAMMAL;
						return false;
				}

				fauna[i].setTypeFauna(newTypeFauna);
				return true;
			}
		}
		return false;

	}




	public boolean searchAndEditFlora(String nameFlora, String newName, String newScientificName, String newFlowers, String newFruits, double newMaxHeight, int typeFlora){
		for (int i = 0; i < flora.length; i++) {
			if (flora[i] != null && flora[i].getName().equals(nameFlora)) {
				flora[i].setName(newName);
				flora[i].setScientificName(newScientificName);
				flora[i].setFlowers(newFlowers);
				flora[i].setFruits(newFruits);
				flora[i].setMaxHeight(newMaxHeight);

				SpeciesTypeFlora selectedType;
				switch (typeFlora) {
					case 1:
						selectedType = SpeciesTypeFlora.AQUATIC_FLORA;
						break;
					case 2:
						selectedType = SpeciesTypeFlora.LAND_FLORA;
						break;
					default:
						selectedType = SpeciesTypeFlora.LAND_FLORA;
						return false;
				}
	
				flora[i].setTypeFlora(selectedType); 
				return true;
			}
		}
		return false;  
	}

	
}


