package ru.javarush.papa.frolov.island.island;


import ru.javarush.papa.frolov.island.organism.Organism;
import ru.javarush.papa.frolov.island.organism.OrganismStats;
import ru.javarush.papa.frolov.island.settings.Settings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location {
    private Map<String, Set<Organism>> inhabitants;
    private List<Location> neighboringLocations;
    private final Lock lock = new ReentrantLock(true);

    public Map<String, Set<Organism>> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(Map<String, Set<Organism>> inhabitants) {
        this.inhabitants = inhabitants;
    }

    public List<Location> getNeighboringLocations() {
        return neighboringLocations;
    }

    public void setNeighboringLocations(List<Location> neighboringLocations) {
        this.neighboringLocations = neighboringLocations;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        HashMap<String, Long> locationStatistics = new HashMap<>();

        inhabitants.entrySet()

                .forEach(entry -> {
                    OrganismStats organismStats = Settings.getInstance().getOrganismStatsByType(entry.getKey());
                    String icon = organismStats.getIcon();
                    long count = entry.getValue().size();
                    locationStatistics.put(icon, count);
                });

        return locationStatistics.toString();
    }

    public void addInhabitant(String organismType, Organism newOrganism) {
        inhabitants.get(organismType).add(newOrganism);
    }
}
