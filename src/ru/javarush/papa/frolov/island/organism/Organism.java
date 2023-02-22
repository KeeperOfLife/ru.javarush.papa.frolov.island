package ru.javarush.papa.frolov.island.organism;

import ru.javarush.papa.frolov.island.organism.animals.Animal;
import ru.javarush.papa.frolov.island.island.Location;
import ru.javarush.papa.frolov.island.settings.Settings;
import ru.javarush.papa.frolov.island.util.Randomizer;

public abstract class Organism {

    private final String type = this.getClass().getSimpleName().toLowerCase();
    private String gender;
    private double weight;

    public abstract void multiply(Location location);

    protected Organism() {
        OrganismStats organismStats = Settings.getInstance().getOrganismStatsByType(this.getType());
        this.weight = organismStats.getWeight();
        int genderPercent = 50;
        if(Randomizer.getChance(genderPercent) && this instanceof Animal) {
            this.gender = "male";
        } else {
            this.gender = "female";
        }
    }

    public void starve(Location location) {
        location.getLock().lock();
// TODO try - finally?
        OrganismStats organismStats = Settings.getInstance().getOrganismStatsByType(this.getType());
        int percentageOfWeightLoss;
        if (this instanceof Animal) {
            percentageOfWeightLoss = 10;
        } else {
            percentageOfWeightLoss = 1;
        }

        double weightLoss = organismStats.getWeight() * percentageOfWeightLoss / 100;
        setWeight(this.getWeight() - weightLoss);

        if (this.getWeight() < organismStats.getWeight() * 0.2) {
            location.getInhabitants().get(this.getType()).remove(this);
        }

        location.getLock().unlock();
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

