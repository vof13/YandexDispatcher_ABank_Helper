
package com.yahelper.yandexdispatcher_abank_helper.rest.driverprofiles.request;

import java.util.HashMap;
import java.util.List;
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
    "account",
    "car",
    "current_status",
    "driver_profile",
    "park"
})
@Generated("jsonschema2pojo")
public class Fields {

    @JsonProperty("account")
    private List<String> account = null;
    @JsonProperty("car")
    private List<String> car = null;
    @JsonProperty("current_status")
    private List<String> currentStatus = null;
    @JsonProperty("driver_profile")
    private List<String> driverProfile = null;
    @JsonProperty("park")
    private List<String> park = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("account")
    public List<String> getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(List<String> account) {
        this.account = account;
    }

    @JsonProperty("car")
    public List<String> getCar() {
        return car;
    }

    @JsonProperty("car")
    public void setCar(List<String> car) {
        this.car = car;
    }

    @JsonProperty("current_status")
    public List<String> getCurrentStatus() {
        return currentStatus;
    }

    @JsonProperty("current_status")
    public void setCurrentStatus(List<String> currentStatus) {
        this.currentStatus = currentStatus;
    }

    @JsonProperty("driver_profile")
    public List<String> getDriverProfile() {
        return driverProfile;
    }

    @JsonProperty("driver_profile")
    public void setDriverProfile(List<String> driverProfile) {
        this.driverProfile = driverProfile;
    }

    @JsonProperty("park")
    public List<String> getPark() {
        return park;
    }

    @JsonProperty("park")
    public void setPark(List<String> park) {
        this.park = park;
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
