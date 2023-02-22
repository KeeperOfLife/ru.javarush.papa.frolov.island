package ru.javarush.papa.frolov.island.organism;

public class OrganismStats {
    private String icon;
    private String name;
    private double weight;
    private float maxFoodRequired;
    private int maxQuantity;
    private int maxSpeed;

    public OrganismStats() {

    }
    public OrganismStats(String name, String icon, double weight, int maxQuantity, int maxSpeed, float maxFoodRequired) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxQuantity = maxQuantity;
        this.maxSpeed = maxSpeed;
        this.maxFoodRequired = maxFoodRequired;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxFoodRequired() {
        return maxFoodRequired;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }


    public String getIcon() {
        return icon;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
