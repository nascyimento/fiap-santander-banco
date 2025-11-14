package com.fiap.banco.exception;

import java.math.BigDecimal;

public class SaldoIndisponivelException extends RuntimeException {
    public SaldoIndisponivelException(BigDecimal saldo, BigDecimal valorDeSaque) {
        super("Saldo insuficiente, saldo: " + saldo + ", valor do saque: " + valorDeSaque);
    }
}


