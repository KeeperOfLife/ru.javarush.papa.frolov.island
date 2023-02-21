package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Deer;

public class DeerFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Deer();
    }
}
