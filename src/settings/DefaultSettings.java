package settings;

import java.util.Map;


public class DefaultSettings {

    private final int ISLAND_OS_X = 100;
    private final int ISLAND_OS_Y = 20;

    private final int CYCLE_DURATION = 1000; //ms
    private final int GAME_DURATION = 60; //sec
    private  final Map<String, Integer> ORGANISM_DEFAULT_QUANTITY = Map.ofEntries(
            Map.entry("wolf", 30),
            Map.entry("snake", 30),
            Map.entry("fox", 30),
            Map.entry("bear", 5),
            Map.entry("eagle", 20),
            Map.entry("horse", 20),
            Map.entry("deer", 20),
            Map.entry("rabbit", 150),
            Map.entry("mouse", 500),
            Map.entry("goat", 140),
            Map.entry("sheep", 140),
            Map.entry("hog", 50),
            Map.entry("duck", 10),
            Map.entry("caterpillar", 1000),
            Map.entry("plant", 200)
    );

    public DefaultSettings() {

    }

    public Map<String, Integer> getORGANISM_DEFAULT_QUANTITY() {
        return ORGANISM_DEFAULT_QUANTITY;
    }
}
