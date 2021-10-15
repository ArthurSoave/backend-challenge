package com.soave.backendchallenge.domain.model;

import java.util.regex.Pattern;

/**
 * Classe responsavel por lidar e manipular a senha a ser validada
 *
 * @author arthursoave
 * @since 10/2021
 */
public class Senha {

    /**
     * Padrao de Regex que garante que a String senha cumpra com os requisitos necessarios para que seja considerada
     * valida:
     * ^ ≥ inicio da String
     * (?=.*[A-Z]) ≥ ao menos uma letra maiúscula
     * (?=.*[!@#$%^&*()-+]) ≥  ao menos um caractere especial
     * (?=.*[a-z]) ≥ ao menos uma letra minuscula
     * (?=.*[0-9]) ≥ ao menos um digito numerico
     * .{9,}$ ≥ no minimo 9 caracteres
     *
     */
    //todo -> implementar no regex a validacao de caratere repetido em sequencia
    private static final String PATTERN = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=.*[a-z])(?=.*[0-9]).{9,}$";

    private boolean isValid;

    public Senha(String senha){
        this.isValid = validaSenha(senha);
    }

    public boolean getIsValid(){
        return this.isValid;
    }

    private boolean validaSenha(String senha){
        return Pattern.matches(PATTERN, senha);
    }

}
