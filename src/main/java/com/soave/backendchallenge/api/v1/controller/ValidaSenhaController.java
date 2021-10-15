package com.soave.backendchallenge.api.v1.controller;

import com.soave.backendchallenge.api.v1.resource.ValidaSenhaResource;
import com.soave.backendchallenge.domain.request.ValidaSenhaRequest;
import com.soave.backendchallenge.domain.response.ValidaSenhaResponse;
import com.soave.backendchallenge.domain.service.ValidaSenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidaSenhaController implements ValidaSenhaResource {

    @Autowired
    private ValidaSenhaService validaSenhaService;

    @Override
    public ResponseEntity<ValidaSenhaResponse> validaSenha(ValidaSenhaRequest validaSenhaRequest) {
        var response = validaSenhaService.validarSenha(validaSenhaRequest);
        return ResponseEntity.ok(response);
    }
}
