package entity.organism.animals;

import entity.organism.Organism;
import island.Location;

public abstract class Animal extends Organism {
    public boolean eat(Location location) {
        return safeEat(location);
    }

    private boolean safeEat(Location location) {
        return true;
    }

    @Override
    public  void multiply(){

    }

    @Override
    public void die(){

    }
}
