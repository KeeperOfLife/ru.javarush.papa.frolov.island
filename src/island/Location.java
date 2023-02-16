package island;



import entity.organism.Organism;

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
        return "Location{" +
                "inhabitants=" + inhabitants +
                '}';
    }
}
