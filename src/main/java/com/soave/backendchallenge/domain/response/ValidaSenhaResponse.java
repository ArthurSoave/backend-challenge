package com.soave.backendchallenge.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidaSenhaResponse {

    @JsonProperty("is_valid")
    private boolean isValid;
}
