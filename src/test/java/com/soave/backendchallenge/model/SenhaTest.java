package com.soave.backendchallenge.model;

import com.soave.backendchallenge.domain.model.Senha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[Senha] - testa de forma unitaria o metodo de validacao da senha")
public class SenhaTest {

    @Test
    @DisplayName("[Senha Invalida] - Retorna false quando senha tem apenas espacos em branco")
    void testaSenhaComEspacoemBranco(){
        var resultadoSenhaValidaObtida = new Senha(" ");
        Assertions.assertFalse(resultadoSenhaValidaObtida.getIsValid());

    }

    @Test
    @DisplayName("[Senha Invalida] - Retorna false quando senha tem menos de 9 caracteres")
    void testaSenhaComMenosDeNoveCaracteres(){
        var resultadoSenhaValidaObtida = new Senha("AbTp9!fo");
        Assertions.assertFalse(resultadoSenhaValidaObtida.getIsValid());
    }

    @Test
    @DisplayName("[Senha Invalida] - Retorna false quando senha nao tem nenhuma letra minuscula")
    void testaSenhaSemLetraMinuscula(){
        var resultadoSenhaValidaObtida = new Senha("ABTP9!FOK");
        Assertions.assertFalse(resultadoSenhaValidaObtida.getIsValid());
    }

    @Test
    @DisplayName("[Senha Invalida] - Retorna false quando senha nao tem nenhuma letra maiuscula")
    void testaSenhaSemLetraMaiuscula(){
        var resultadoSenhaValidaObtida = new Senha("abtp9!fok");
        Assertions.assertFalse(resultadoSenhaValidaObtida.getIsValid());
    }

    @Test
    @DisplayName("[Senha Invalida] - Retorna false quando senha nao tem nenhum caractere especial")
    void testaSenhaSemCaractereEspecial(){
        var resultadoSenhaValidaObtida = new Senha("AbTp9Afok");
        Assertions.assertFalse(resultadoSenhaValidaObtida.getIsValid());
    }

    @Test
    @DisplayName("[Senha Invalida] - Retorna false quando senha tem sequencia de caracteres")
    void testaSenhaComSequenciaDeCaracteres(){
        var resultadoSenhaValidaObtida = new Senha("AAbTp9!fok");
        Assertions.assertFalse(resultadoSenhaValidaObtida.getIsValid());
    }

    @Test
    @DisplayName("[Senha Valida] - retorna true quando a senha corresponde aos requisitos")
    void testaSenhaValida(){
        var resultadoSenhaValidaObtida = new Senha("AbTp9!fok");
        Assertions.assertTrue(resultadoSenhaValidaObtida.getIsValid());
    }

}
