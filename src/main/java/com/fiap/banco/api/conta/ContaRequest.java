package com.fiap.banco.api.conta;

import com.fiap.banco.domain.TipoContaEnum;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ContaRequest {

    @NotNull
    private Integer id;

    @NotNull
    private Integer numero;

    @NotBlank
    private String agencia;

    @NotBlank
    private String cpf;

    @NotBlank
    private String nome;

    @NotNull
    private TipoContaEnum tipoDeConta;

    @NotBlank
    private String endereco;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal saldo;

    private Long usuarioId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoContaEnum getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(TipoContaEnum tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}

