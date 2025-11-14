package com.fiap.banco.domain;

public enum TipoContaEnum {

    CONTA_CORRENTE(0.02),
    CONTA_POUPANCA(0.01),
    CONTA_INVESTIMENTO(0.03);

    private final double taxaDeTransacao;

    TipoContaEnum(double taxaDeTransacao) {
        this.taxaDeTransacao = taxaDeTransacao;
    }

    public double getPercentualDaTaxa() {
        return this.taxaDeTransacao;
    }
}
