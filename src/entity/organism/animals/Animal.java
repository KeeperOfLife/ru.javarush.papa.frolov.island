package entity.organism.animals;

import entity.organism.Organism;
import entity.organism.OrganismStats;
import entity.organism.factories.OrgansimFactories;
import island.Location;
import settings.Settings;
import util.Randomizer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Animal extends Organism {

    public boolean eat(Location location) {
        location.getLock().lock();
        boolean ate = false;

        try {
            int minStarvingPer = 20;                    // An animal losing 20 percent of its weight starts looking for food
            OrganismStats animalStats = Settings.get().getOrganismStatsByType(this.getType());

            if (this.getWeight() < animalStats.getWeight() * minStarvingPer / 100) {
                Map<String, Integer> chanceToGetFoodMap = Settings.get().getChanceToGetFood().get(this.getType());
                Iterator<Map.Entry<String, Integer>> chanceToGetFoodIterator = chanceToGetFoodMap.entrySet().iterator();

                while (this.getWeight() < animalStats.getWeight() * minStarvingPer / 100 && chanceToGetFoodIterator.hasNext()) {
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
                            } else {
                                this.setWeight(this.getWeight() + resultWeight);
                            }
                            victimsIterator.remove();
                            ate = true;
                        }
                    }
                }
            }
        } finally {
            location.getLock().unlock();
        }
        return ate;
    }

    @Override
    public void multiply(Location location) {
        location.getLock().lock();

        try {
            Set<Organism> animalsSet = location.getInhabitants().get(this.getType());
            if (animalsSet != null) {
                for (Organism animal : animalsSet) {
                    if (!animal.getGender().equals(this.getGender())) {
                        int chanceOfProgeny = 50;
                        if (Randomizer.getChance(chanceOfProgeny)) {
                            int childQuantity = Randomizer.getRandom(0, Settings.get().getOrganismChildQuantity().get(this.getType()));
                            for (int i = 0; i < childQuantity; i++) {
                                location.addInhabitant(animal.getType(), OrgansimFactories.createOrganismByType(animal.getType()));
                            }
                        }
                    }
                }
            }

        } catch (NullPointerException e) {
            System.out.println("На локации нет животного данного вида: " + Settings.get().getOrganismStatsByType(this.getType()).getIcon());
        } finally {
            location.getLock().unlock();
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