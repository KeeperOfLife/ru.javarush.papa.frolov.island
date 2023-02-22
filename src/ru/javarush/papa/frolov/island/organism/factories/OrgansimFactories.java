package ru.javarush.papa.frolov.island.organism.factories;

import ru.javarush.papa.frolov.island.organism.Organism;
import ru.javarush.papa.frolov.island.organism.animals.herbivores.*;
import ru.javarush.papa.frolov.island.organism.animals.predators.*;
import ru.javarush.papa.frolov.island.organism.plants.Plant;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrgansimFactories {

    public static Organism createOrganismByType(String organismType) {
        switch (organismType) {
            case "wolf":
                return new Wolf();
            case "snake":
                return new Snake();
            case "fox":
                return new Fox();
            case "bear":
                return new Bear();
            case "eagle":
                return new Eagle();
            case "horse":
                return new Horse();
            case "deer":
                return new Deer();
            case "rabbit":
                return new Rabbit();
            case "mouse":
                return new Mouse();
            case "goat":
                return new Goat();
            case "sheep":
                return new Sheep();
            case "hog":
                return new Hog();
            case "buffalo":
                return new Buffalo();
            case "duck":
                return new Duck();
            case "caterpillar":
                return new Caterpillar();
            case "plant":
                return new Plant();
            default:
                throw new IllegalArgumentException("Wrong name for entity");
        }
    }

}
