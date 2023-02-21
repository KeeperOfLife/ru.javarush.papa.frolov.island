package settings;


import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import entity.organism.OrganismStats;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Settings {

    private static final String SETTINGS_PATH = "resources/settings.json";
    private static volatile Settings SETTINGS;

    private int islandOsX;
    private int islandOsY;

    private int cycleDuration;  // millis
    private int gameDuration;   // millis

    private Map<String, Integer> organismInitialQuantity;
    private Map<String, Integer> organismChildQuantity;
    private Map<String, Map<String, Integer>> chanceToGetFood;
    private Map<String, OrganismStats> organismsStats;

    private List<String> organismsTypes;


    private Settings() {
        try {
            URL resource = Settings.class.getClassLoader().getResource(SETTINGS_PATH);
            ObjectReader objectReader = new JsonMapper().readerForUpdating(this);
            if (Objects.nonNull(resource)) {
                objectReader.readValue(resource.openStream());
            }
            organismsTypes = new ArrayList<>(organismsStats.keySet());
        } catch (IOException e) {
            System.out.println("file \"settings.json\" was not found");
        }
    }

    public static Settings get() {
        Settings settings = SETTINGS;
        if (Objects.isNull(settings)) {
            synchronized (Settings.class) {
                if (Objects.isNull(settings = SETTINGS)) {
                    settings = SETTINGS = new Settings();
                }
            }
        }
        return settings;
    }

    public int getIslandOsX() {
        return islandOsX;
    }

    public int getIslandOsY() {
        return islandOsY;
    }

    public int getCycleDuration() {
        return cycleDuration;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public Map<String, Integer> getOrganismInitialQuantity() {
        return organismInitialQuantity;
    }

    public Map<String, Integer> getOrganismChildQuantity() {
        return organismChildQuantity;
    }

    public Map<String, Map<String, Integer>> getChanceToGetFood() {
        return chanceToGetFood;
    }

    public Map<String, OrganismStats> getOrganismsStats() {
        return organismsStats;
    }

    public OrganismStats getOrganismStatsByType(String organismType) {
        return organismsStats.get(organismType);
    }

    public List<String> getOrganismsTypes() {
        return organismsTypes;
    }

}
