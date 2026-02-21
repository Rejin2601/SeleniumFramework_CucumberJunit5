package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;

public class FileReader {
    private JsonObject jsonObject;

    public String getConfigValue(String key) throws FileNotFoundException {
        jsonObject = JsonParser.parseReader(new java.io.FileReader("src/main/java/config/appConfig.json")).getAsJsonObject();
        // Get value
        String value = jsonObject.get(key).getAsString();
        System.out.println("Value is: " + value);
        return value;
    }
}
