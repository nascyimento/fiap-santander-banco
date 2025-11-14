package com.fiap.banco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private Integer numero;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String agencia;

    @NotBlank
    @Column(nullable = false, length = 14)
    private String cpf;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_conta", nullable = false, length = 20)
    private TipoContaEnum tipoDeConta = TipoContaEnum.CONTA_CORRENTE;

    @Column(length = 200)
    private String endereco;

    @NotNull
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal saldo = BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = true)
    private Usuario usuario;

    public Conta() {
    }

    public Conta(Integer id, Integer numero, String agencia, String cpf, String nome, TipoContaEnum tipo, String endereco, BigDecimal saldo, Usuario usuario) {
        this.numero = numero;
        this.agencia = agencia;
        this.cpf = cpf;
        this.nome = nome;
        this.tipoDeConta = tipo;
        this.endereco = endereco;
        this.saldo = saldo;
        this.usuario = usuario;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

