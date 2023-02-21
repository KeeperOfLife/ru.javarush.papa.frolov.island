package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.plants.Plant;

public class PlantFactory implements OrganismFactory{

    @Override
    public Organism createOrganism() {
        return new Plant();
    }
}
