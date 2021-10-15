package com.soave.backendchallenge.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soave.backendchallenge.domain.request.ValidaSenhaRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ValidaSenhaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("[Senha Invalida] - Retorna false quando senha é inválida")
    void testaIntegradoSenhaInvalida()throws Exception{

        ValidaSenhaRequest validaSenhaRequest = new ValidaSenhaRequest("AbTp9!fo");
        var result = mockMvc.perform(post("/v1/validacoes/validacao")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(validaSenhaRequest)))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertTrue(result.getResponse().getContentAsString().contains("false"));
    }

    @Test
    @DisplayName("[Senha válida] - Retorna true quando senha é válida")
    void testaIntegradoSenhaValida()throws Exception{

        ValidaSenhaRequest validaSenhaRequest = new ValidaSenhaRequest("AbTp9!foI");
        var result = mockMvc.perform(post("/v1/validacoes/validacao")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(validaSenhaRequest)))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertTrue(result.getResponse().getContentAsString().contains("true"));
    }

    @Test
    @DisplayName("[HTTP Status] - Retorna NOT_FOUND(404) quando a URI não é encontrada")
    void testaIntegradoHttpNotFound()throws Exception{

        ValidaSenhaRequest validaSenhaRequest = new ValidaSenhaRequest("AbTp9!foI");
        mockMvc.perform(post("/v2/validacoes/validacao")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(validaSenhaRequest)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("[HTTP Status] - Retorna BAD_REQUEST(400) quando a requisicao esta mal formada")
    void testaIntegradoHttpBadGateway()throws Exception{

        mockMvc.perform(post("/v1/validacoes/validacao")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isBadRequest());
    }
}
