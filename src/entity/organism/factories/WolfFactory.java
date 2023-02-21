package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.predators.Wolf;

public class WolfFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Wolf();
    }
}
