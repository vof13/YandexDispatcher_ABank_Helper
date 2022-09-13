package com.yahelper.yandexdispatcher_abank_helper.rest.driverwokrules;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "is_enabled",
        "name"
})
@Generated("jsonschema2pojo")
public class RestRule {

    @JsonProperty("id")
    private String id;
    @JsonProperty("is_enabled")
    private boolean isEnabled;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Rule{" +
                "id='" + id + '\'' +
                ", isEnabled=" + isEnabled +
                ", name='" + name + '\'' +
                '}';
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("is_enabled")
    public boolean isIsEnabled() {
        return isEnabled;
    }

    @JsonProperty("is_enabled")
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}