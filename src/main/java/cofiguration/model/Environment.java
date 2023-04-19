package cofiguration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    Map<String, EnvironmentModel> envProperties = new LinkedHashMap<>();

    @JsonAnySetter
    public void setEnvProperties(String key, EnvironmentModel envModel) {
        envProperties.put(key, envModel);
    }

    @JsonAnyGetter
    public List<EnvironmentModel> getEnvProperties() {
        return envProperties.values().stream().toList();
    }

}
