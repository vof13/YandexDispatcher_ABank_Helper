
package com.yahelper.yandexdispatcher_abank_helper.rest.driverprofiles.request;

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
    "driver_profile",
    "id"
})
@Generated("jsonschema2pojo")
public class Park {

    @JsonProperty("driver_profile")
    private DriverProfileForResponse driverProfileForRequestRequest;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Park(String id) {
        this.id = id;
    }

    @JsonProperty("driver_profile")
    public DriverProfileForResponse getDriverProfile() {
        return driverProfileForRequestRequest;
    }

    @JsonProperty("driver_profile")
    public void setDriverProfile(DriverProfileForResponse driverProfileForRequestRequest) {
        this.driverProfileForRequestRequest = driverProfileForRequestRequest;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
