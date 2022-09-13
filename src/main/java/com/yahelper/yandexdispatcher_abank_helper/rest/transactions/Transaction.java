
package com.yahelper.yandexdispatcher_abank_helper.rest.transactions;

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
    "category_ids",
    "event_at"
})
@Generated("jsonschema2pojo")
public class Transaction {

    @JsonProperty("category_ids")
    private List<String> categoryIds = null;
    @JsonProperty("event_at")
    private EventAt eventAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Transaction(EventAt eventAt) {
        this.eventAt = eventAt;
    }

    @JsonProperty("category_ids")
    public List<String> getCategoryIds() {
        return categoryIds;
    }

    @JsonProperty("category_ids")
    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    @JsonProperty("event_at")
    public EventAt getEventAt() {
        return eventAt;
    }

    @JsonProperty("event_at")
    public void setEventAt(EventAt eventAt) {
        this.eventAt = eventAt;
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
