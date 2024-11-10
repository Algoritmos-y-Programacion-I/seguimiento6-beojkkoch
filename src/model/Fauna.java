package model;

public class Fauna extends Species{

    private String migratory;
    private double maxWeight;
    private SpeciesTypeFauna typeFauna;

    public Fauna(String name, String scientificName, String migratory, double maxWeight, SpeciesTypeFauna typeFauna) {
        super(name, scientificName);
        this.migratory = migratory;
        this.maxWeight = maxWeight;
        this.typeFauna = typeFauna;
    }
    
    public String isMigratory() {
        return migratory;
    }
    public void setMigratory(String migratory) {
        this.migratory = migratory;
    }
    public double getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public SpeciesTypeFauna getTypeFauna() {
        return typeFauna;
    }

    public void setTypeFauna(SpeciesTypeFauna typeFauna) {
        this.typeFauna = typeFauna;
    }

    @Override
    public String toString() {
        return super.toString()+ " - Migratory: "+migratory+ " - Maximum Weight: " +maxWeight+ "kg";
    }
    
}
