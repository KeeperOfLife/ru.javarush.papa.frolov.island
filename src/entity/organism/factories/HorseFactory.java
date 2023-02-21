package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Horse;

public class HorseFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Horse();
    }
}
