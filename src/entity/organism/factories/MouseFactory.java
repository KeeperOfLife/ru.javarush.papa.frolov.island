package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Mouse;

public class MouseFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Mouse();
    }
}
