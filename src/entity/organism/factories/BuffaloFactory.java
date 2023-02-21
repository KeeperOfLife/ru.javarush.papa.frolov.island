package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Buffalo;

public class BuffaloFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Buffalo();
    }
}
