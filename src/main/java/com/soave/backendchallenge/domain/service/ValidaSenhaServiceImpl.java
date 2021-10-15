package com.soave.backendchallenge.domain.service;

import com.soave.backendchallenge.domain.model.Senha;
import com.soave.backendchallenge.domain.request.ValidaSenhaRequest;
import com.soave.backendchallenge.domain.response.ValidaSenhaResponse;
import org.springframework.stereotype.Service;

@Service
public class ValidaSenhaServiceImpl implements ValidaSenhaService{


    @Override
    public ValidaSenhaResponse validarSenha(ValidaSenhaRequest validaSenhaRequest) {
        var senha = new Senha(validaSenhaRequest.getSenha());
        return new ValidaSenhaResponse(senha);
    }
}
