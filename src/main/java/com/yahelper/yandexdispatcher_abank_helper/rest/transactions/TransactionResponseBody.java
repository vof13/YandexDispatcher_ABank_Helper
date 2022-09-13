package com.yahelper.yandexdispatcher_abank_helper.rest.transactions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "transactions"
})
public class TransactionResponseBody {

    @JsonProperty("transactions")
    private List<TransactionResponse> transactionResponses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("transactions")
    public List<TransactionResponse> getTransactionResponses() {
        return transactionResponses;
    }

    @JsonProperty("transactions")
    public void setTransactionResponses(List<TransactionResponse> transactionResponses) {
        this.transactionResponses = transactionResponses;
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
