package settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import entity.organism.Organism;
import entity.organism.OrganismStats;

import java.io.IOException;
import java.net.URL;
import java.util.*;

//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Settings {

    private static final String SETTINGS_PATH = "settings.json";

    private static volatile Settings SETTINGS;


    private int islandOsX;
    private int islandOsY;

    private int cycleDuration;
    private int gameDuration;

    private Map<String, Integer> organismInitialQuantity;
    private Map<String, Integer> organismChildQuantity;
    private Map<String, Map<String, Integer>> chanceToGetFood;
    private Map<String, OrganismStats> organismStats;

    private List<String> organismsTypes;

    private Settings() throws IOException {
        URL resource = Settings.class.getClassLoader().getResource(SETTINGS_PATH);
        ObjectReader objectReader = new JsonMapper().readerForUpdating(this);
        if (Objects.nonNull(resource)) {
            objectReader.readValue(resource.openStream());
        }

        organismsTypes = new ArrayList<>(organismStats.keySet());
    }

    public static Settings get() throws IOException {
        Settings settings = SETTINGS;
        if (Objects.isNull(settings)) {
            synchronized (Settings.class) {
                if (Objects.isNull(settings = SETTINGS)) {
                    SETTINGS = new Settings();
                    settings = SETTINGS;
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

    public Map<String, OrganismStats> getOrganismStats() {
        return organismStats;
    }

    public List<String> getOrganismsTypes() {
        return organismsTypes;
    }

}
