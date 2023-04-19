package cofiguration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestData {
    Map<String, Object> testDataProperties = new LinkedHashMap<>();

    @JsonAnySetter
    public void setTestDataProperties(String key, Object value) {
        testDataProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getTestDataProperties() {
        return testDataProperties;
    }
}
