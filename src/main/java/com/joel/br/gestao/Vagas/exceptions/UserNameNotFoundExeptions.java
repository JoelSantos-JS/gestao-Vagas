package com.joel.br.gestao.Vagas.exceptions;

public class UserNameNotFoundExeptions extends RuntimeException{
    public UserNameNotFoundExeptions() {
        super();
    }

    public UserNameNotFoundExeptions(String message) {
        super(message);
    }
}
