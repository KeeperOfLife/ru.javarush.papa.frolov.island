package entity.organism;

import settings.Settings;

import java.io.IOException;

public abstract class Organism {

    private final String type = this.getClass().getSimpleName();

    protected Organism() {
//        OrganismStats organismStats = Settings.get().getOrganismStats().get(this.type);
    }
    public abstract void multiply();
    public abstract void die();

}
