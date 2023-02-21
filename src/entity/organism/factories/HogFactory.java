package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Hog;

public class HogFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Hog();
    }
}
