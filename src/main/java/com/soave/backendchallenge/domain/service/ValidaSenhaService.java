package com.soave.backendchallenge.domain.service;

import com.soave.backendchallenge.domain.request.ValidaSenhaRequest;
import com.soave.backendchallenge.domain.response.ValidaSenhaResponse;

public interface ValidaSenhaService {

    ValidaSenhaResponse validarSenha(ValidaSenhaRequest validaSenhaRequest);
}
