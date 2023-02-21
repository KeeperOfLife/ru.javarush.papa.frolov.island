package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.predators.Eagle;

public class EagleFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Eagle();
    }
}
