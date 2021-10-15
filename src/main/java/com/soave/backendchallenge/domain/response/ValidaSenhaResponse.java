package com.soave.backendchallenge.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soave.backendchallenge.domain.model.Senha;

public class ValidaSenhaResponse {

    @JsonProperty("is_valid")
    private boolean isValid;

    public ValidaSenhaResponse(Senha senha){
        this.isValid = senha.getIsValid();
    }

    public boolean isValid() {
        return isValid;
    }
}
