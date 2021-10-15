package com.soave.backendchallenge.domain.service;

import com.soave.backendchallenge.domain.request.ValidaSenhaRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidaSenhaServiceTests {

    @Autowired
    private ValidaSenhaService validaSenhaService;

    @Test
    @DisplayName("[Senha Invalida - Service Layer] - Retorna false quando senha e invalida")
    void testaSenhaInvalida() {
        ValidaSenhaRequest validaSenhaRequest = new ValidaSenhaRequest("    ");
        var retorno = validaSenhaService.validarSenha(validaSenhaRequest);
        Assertions.assertFalse(retorno.isValid());
    }

    @Test
    @DisplayName("[Senha Valida - Service Layer] - Retorna true quando senha e valida")
    void testaSenhaValida() {
        ValidaSenhaRequest validaSenhaRequest = new ValidaSenhaRequest("AbTp9!foI");
        var retorno = validaSenhaService.validarSenha(validaSenhaRequest);
        Assertions.assertTrue(retorno.isValid());
    }
}