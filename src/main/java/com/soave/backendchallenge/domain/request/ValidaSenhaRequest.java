package com.soave.backendchallenge.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidaSenhaRequest {

    @JsonProperty("senha")
    private String senha;

    public String getSenha() {
        return senha;
    }
}
