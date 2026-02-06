package helper;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> contextData;

    public ScenarioContext() {
        contextData = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        contextData.put(key, value);
    }

    public Object getContext(String key) {
        return contextData.get(key);
    }

    public Boolean contains(String key) {
        return contextData.containsKey(key);
    }
}

