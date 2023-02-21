package entity.organism.factories;

import entity.organism.Organism;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrgansimFactories {

    private static volatile OrgansimFactories FACTORIES;
    private final Map<String, OrganismFactory> FACTORIES_MAP;
    private OrgansimFactories() {
        FACTORIES_MAP = new HashMap<>();
        FACTORIES_MAP.put("wolf", new WolfFactory());
        FACTORIES_MAP.put("snake", new SnakeFactory());
        FACTORIES_MAP.put("fox", new FoxFactory());
        FACTORIES_MAP.put("bear", new BearFactory());
        FACTORIES_MAP.put("eagle", new EagleFactory());
        FACTORIES_MAP.put("horse", new HorseFactory());
        FACTORIES_MAP.put("deer", new DeerFactory());
        FACTORIES_MAP.put("rabbit", new RabbitFactory());
        FACTORIES_MAP.put("mouse", new MouseFactory());
        FACTORIES_MAP.put("goat", new GoatFactory());
        FACTORIES_MAP.put("sheep", new SheepFactory());
        FACTORIES_MAP.put("hog", new HogFactory());
        FACTORIES_MAP.put("buffalo", new BuffaloFactory());
        FACTORIES_MAP.put("duck", new DuckFactory());
        FACTORIES_MAP.put("caterpillar", new CaterpillarFactory());
        FACTORIES_MAP.put("plant", new PlantFactory());
    }

    private static Map<String, OrganismFactory> getFactoriesMap() {
        OrgansimFactories factories = FACTORIES;
        if (Objects.isNull(factories)) {
            synchronized (OrgansimFactories.class) {
                if (Objects.isNull(factories = FACTORIES)) {
                    factories = FACTORIES = new OrgansimFactories();
                }
            }
        }

        return factories.FACTORIES_MAP;
    }

    public static Organism createOrganismByType(String organismType) {
        return getFactoriesMap().get(organismType).createOrganism();
    }


}
