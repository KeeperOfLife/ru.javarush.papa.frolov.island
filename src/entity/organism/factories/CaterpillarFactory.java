package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Caterpillar;

public class CaterpillarFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Caterpillar();
    }
}
