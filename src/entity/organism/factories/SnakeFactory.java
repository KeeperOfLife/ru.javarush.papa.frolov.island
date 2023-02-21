package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.predators.Snake;

public class SnakeFactory implements OrganismFactory{

    @Override
    public Organism createOrganism() {
        return new Snake();
    }
}
