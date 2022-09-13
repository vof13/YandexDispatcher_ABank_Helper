package com.yahelper.yandexdispatcher_abank_helper.rest.driverprofiles.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "driver_profiles"
})
public class ProfilesResponseBody {

    @JsonProperty("driver_profiles")
    private List<ProfilesResponse> profilesResponses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("driver_profiles")
    public List<ProfilesResponse> getProfilesResponses() {
        return profilesResponses;
    }

    @JsonProperty("driver_profiles")
    public void setProfilesResponses(List<ProfilesResponse> profilesResponses) {
        this.profilesResponses = profilesResponses;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
