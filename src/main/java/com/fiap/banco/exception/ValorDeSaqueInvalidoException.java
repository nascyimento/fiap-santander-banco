package com.fiap.banco.exception;

public class ValorDeSaqueInvalidoException extends RuntimeException {
    public ValorDeSaqueInvalidoException() {
        super("Valor de saque invalido");
    }
}
