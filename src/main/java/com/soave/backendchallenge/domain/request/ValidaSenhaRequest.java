package com.soave.backendchallenge.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidaSenhaRequest {

    @JsonProperty("senha")
    private String senha;

    public ValidaSenhaRequest() {
    }

    public ValidaSenhaRequest(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
