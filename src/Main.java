import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import settings.DefaultSettings;
import settings.Settings;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Settings.get().getOrganismStats().get("wolf").getWeight());
    }
}