package model;

public class Flora extends Species{

    private String flowers;
    private String fruits;
    private double maxHeight;
    private SpeciesTypeFlora typeFlora;

    public Flora(String name, String scientificName, String flowers, String fruits, double maxHeight, SpeciesTypeFlora typeFlora) {
        super(name, scientificName);
        this.flowers = flowers;
        this.fruits = fruits;
        this.maxHeight = maxHeight;
        this.typeFlora = typeFlora;
    }
    
    public String isFlowers() {
        return flowers;
    }
    public void setFlowers(String flowers) {
        this.flowers = flowers;
    }
    public String isFruits() {
        return fruits;
    }
    public void setFruits(String fruits) {
        this.fruits = fruits;
    }
    public double getMaxHeight() {
        return maxHeight;
    }
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public SpeciesTypeFlora getTypeFlora() {
        return typeFlora;
    }

    public void setTypeFlora(SpeciesTypeFlora typeFlora) {
        this.typeFlora = typeFlora;
    }

    @Override
    public String toString() {
        return super.toString()+ "- Flowers: "+flowers+ " - Fruits: " +fruits+ " - Maxumum Height: " +maxHeight+"m";
    }


    
    
}
