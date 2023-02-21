package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.predators.Bear;

public class BearFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Bear();
    }
}
