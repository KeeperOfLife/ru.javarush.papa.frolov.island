package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Sheep;

public class SheepFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Sheep();
    }
}
