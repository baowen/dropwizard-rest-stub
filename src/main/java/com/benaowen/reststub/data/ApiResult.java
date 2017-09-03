package com.benaowen.reststub.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by benowen on 03/09/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResult {

    /** boolean flag for status of the rest call.*/
    private boolean success;

    private String message;

    public ApiResult() {}

    @JsonProperty
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public boolean isSuccess() { return success;}

    public void setSuccess(boolean success) { this.success = success;}
}
