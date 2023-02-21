package entity.organism.factories;

import entity.organism.Organism;
import entity.organism.animals.herbivores.Rabbit;

public class RabbitFactory implements OrganismFactory {

    @Override
    public Organism createOrganism() {
        return new Rabbit();
    }
}
