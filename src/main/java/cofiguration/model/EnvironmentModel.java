package cofiguration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnvironmentModel {
    public boolean active;

    public boolean isActive() {
        return active;
    }

    Map<String, Object> modelProperties = new LinkedHashMap<>();

    @JsonAnySetter
    public void setModelProperties(String key, Object value) {
        modelProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getModelProperties() {
        return modelProperties;
    }
}
