package com.sindify.condominio.controller.exception;

public class ControllerNotFoundException extends RuntimeException {
    public ControllerNotFoundException(String mensagem) {
        super(mensagem);
    }
}
