package ru.javarush.papa.frolov.island.organism.animals;

import ru.javarush.papa.frolov.island.organism.Organism;
import ru.javarush.papa.frolov.island.organism.OrganismStats;
import ru.javarush.papa.frolov.island.organism.factories.OrgansimFactories;
import ru.javarush.papa.frolov.island.island.Location;
import ru.javarush.papa.frolov.island.settings.Settings;
import ru.javarush.papa.frolov.island.util.PercentConverter;
import ru.javarush.papa.frolov.island.util.Randomizer;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class Animal extends Organism {

    public void eat(Location location) {
        location.getLock().lock();

        try {
            int minStarvingPer = 20;               // An animal losing 20 percent of its weight starts looking for food
            OrganismStats animalStats = Settings.getInstance().getOrganismStatsByType(this.getType());
            boolean isStarved = this.getWeight() < animalStats.getWeight() * PercentConverter.convert(minStarvingPer);

            if (isStarved) {
                Map<String, Integer> chanceToGetFoodMap = Settings.getInstance().getChanceToGetFood().get(this.getType());
                Iterator<Map.Entry<String, Integer>> chanceToGetFoodIterator = chanceToGetFoodMap.entrySet().iterator();

                while (isStarved && chanceToGetFoodIterator.hasNext()) {
                    Map.Entry<String, Integer> chanceToGetFood = chanceToGetFoodIterator.next();
                    String foodType = chanceToGetFood.getKey();
                    Integer chanceToEat = chanceToGetFood.getValue();
                    Set<Organism> victimsSet = location.getInhabitants().get(foodType);

                    if (Randomizer.getChance(chanceToEat) && victimsSet != null && !victimsSet.isEmpty()) {
                        Iterator<Organism> victimsIterator = victimsSet.iterator();

                        if (victimsIterator.hasNext()) {
                            Organism victim = victimsIterator.next();
                            double resultWeight = Math.min(victim.getWeight(), animalStats.getMaxFoodRequired());

                            if (resultWeight >= animalStats.getMaxFoodRequired()) {
                                this.setWeight(animalStats.getWeight());
                                isStarved = false;
                            } else {
                                this.setWeight(this.getWeight() + resultWeight);
                            }
                            victimsIterator.remove();

                        }
                    }
                }
            }
        } finally {
            location.getLock().unlock();
        }
        
    }

    @Override
    public void multiply(Location location) {
        location.getLock().lock();

        try {
            Set<Organism> animalsSet = location.getInhabitants().get(this.getType());
            if (animalsSet != null) {
                for (Organism animal : animalsSet) {
                    multiplyByType(location, animal);
                }
            }
        } finally {
            location.getLock().unlock();
        }
    }

    private void multiplyByType(Location location, Organism animal) {
        boolean isNotTheSameGender = !animal.getGender().equals(this.getGender());
        int probabilityPerBrood = 50;
        if (Randomizer.getChance(probabilityPerBrood) && isNotTheSameGender) {
            int childQuantity = Randomizer.getRandom(0, Settings.getInstance().getOrganismChildQuantity().get(this.getType()));
            for (int i = 0; i < childQuantity; i++) {
                location.addInhabitant(animal.getType(), OrgansimFactories.createOrganismByType(animal.getType()));
            }
        }
    }
//              IN DEV
//    public void move(Location CurrentLocation) {
//        CurrentLocation.getLock().lock();
//        try {
//            int maxSpeed = Settings.get().getOrganismStatsByType(this.getType()).getMaxSpeed();
//            int actualSpeed = Randomizer.getRandom(0, maxSpeed);
//            List<Location> destLocation = CurrentLocation.getNeighboringLocations();
//            if (actualSpeed > 0) {
//                int destLocationIndex = Randomizer.getRandom(0, destLocation.size());
//                if (destLocationIndex == 0) {
//
//                }
//            }
//        }
//    }
}