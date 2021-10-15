package com.soave.backendchallenge.api.v1.resource;

import com.soave.backendchallenge.domain.request.ValidaSenhaRequest;
import com.soave.backendchallenge.domain.response.ValidaSenhaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "Recursos referentes a validacao de senha")
@RequestMapping("/v1/validacoes")
public interface ValidaSenhaResource {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Valida se uma senha atende aos requisitos de segurança",
                  notes = "Para que a senha seja válida, deve conter pelo menos 9 caracteres, 1 numeral, 1 caractere especial, " +
                        "uma letra maiúscula, uma letra minuscula e não possuir caracteres repetidos em sequencia.")
    @PostMapping(value = "/validacao",consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<ValidaSenhaResponse> validaSenha(@RequestBody ValidaSenhaRequest validaSenhaRequest);

}
