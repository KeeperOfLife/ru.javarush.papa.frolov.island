package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Duck;

public class DuckFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Duck();
    }
}
