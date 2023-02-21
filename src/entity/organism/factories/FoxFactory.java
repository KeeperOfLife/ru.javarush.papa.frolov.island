package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.predators.Fox;

public class FoxFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Fox();
    }
}
