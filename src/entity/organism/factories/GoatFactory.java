package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Goat;

public class GoatFactory implements OrganismFactory{

    @Override
    public Organism createOrganism() {
        return new Goat();
    }
}
