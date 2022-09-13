
package com.yahelper.yandexdispatcher_abank_helper.rest.driverprofiles.response;

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
    "accounts",
    "car",
    "driver_profile"
})
@Generated("jsonschema2pojo")
public class ProfilesResponse {

    @JsonProperty("accounts")
    private List<Account> accounts = null;
    @JsonProperty("car")
    private Car car;
    @JsonProperty("driver_profile")
    private DriverProfileForResponse driverProfileForResponse;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("accounts")
    public List<Account> getAccounts() {
        return accounts;
    }

    @JsonProperty("accounts")
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @JsonProperty("car")
    public Car getCar() {
        return car;
    }

    @JsonProperty("car")
    public void setCar(Car car) {
        this.car = car;
    }

    @JsonProperty("driver_profile")
    public DriverProfileForResponse getDriverProfile() {
        return driverProfileForResponse;
    }

    @JsonProperty("driver_profile")
    public void setDriverProfile(DriverProfileForResponse driverProfileForResponse) {
        this.driverProfileForResponse = driverProfileForResponse;
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
