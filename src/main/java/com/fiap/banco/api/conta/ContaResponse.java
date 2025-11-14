package com.fiap.banco.api.conta;

import com.fiap.banco.domain.TipoContaEnum;
import java.math.BigDecimal;

public class ContaResponse {
    private Integer id;
    private Integer numero;
    private String agencia;
    private String cpf;
    private String nome;
    private TipoContaEnum tipoDeConta;
    private String endereco;
    private BigDecimal saldo;

    public ContaResponse(Integer id, Integer numero, String agencia, String cpf, String nome,
                         TipoContaEnum tipoDeConta, String endereco, BigDecimal saldo) {
        this.id = id; this.numero = numero; this.agencia = agencia; this.cpf = cpf;
        this.nome = nome; this.tipoDeConta = tipoDeConta; this.endereco = endereco; this.saldo = saldo;
    }

    public Integer getId() { return id; }
    public Integer getNumero() { return numero; }
    public String getAgencia() { return agencia; }
    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public TipoContaEnum getTipoDeConta() { return tipoDeConta; }
    public String getEndereco() { return endereco; }
    public BigDecimal getSaldo() { return saldo; }
}

