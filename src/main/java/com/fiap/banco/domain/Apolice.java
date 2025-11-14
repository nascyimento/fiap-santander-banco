package com.fiap.banco.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Apolice {

    private Long id;
    private String titular;
    private String cpf;
    private String endereco;
    private BigDecimal totalCobertura;
    private LocalDate vencimento;
    private TipoSeguroEnum tipoSeguroEnum;
    private List<Bem> listaDeBens;

    public Apolice(String endereco, String cpf, String titular, LocalDate vencimento, TipoSeguroEnum tipoSeguroEnum, List<Bem> listaDeBens, BigDecimal totalCobertura) {
        this.endereco = endereco;
        this.cpf = cpf;
        this.titular = titular;
        this.vencimento = vencimento;
        this.tipoSeguroEnum = tipoSeguroEnum;
        this.listaDeBens = listaDeBens;
        this.totalCobertura = totalCobertura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Apolice apolice = (Apolice) o;
        return Objects.equals(id, apolice.id) && Objects.equals(titular, apolice.titular) && Objects.equals(cpf, apolice.cpf) && Objects.equals(endereco, apolice.endereco) && Objects.equals(totalCobertura, apolice.totalCobertura) && Objects.equals(vencimento, apolice.vencimento) && Objects.equals(tipoSeguroEnum, apolice.tipoSeguroEnum) && Objects.equals(listaDeBens, apolice.listaDeBens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titular, cpf, endereco, totalCobertura, vencimento, tipoSeguroEnum, listaDeBens);
    }

    @Override
    public String toString() {
        return "Apolice{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", totalCobertura=" + totalCobertura +
                ", vencimento=" + vencimento +
                ", tipoSeguroEnum=" + tipoSeguroEnum +
                ", listaDeBens=" + listaDeBens +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getTotalCobertura() {
        return totalCobertura;
    }

    public void setTotalCobertura(BigDecimal totalCobertura) {
        this.totalCobertura = totalCobertura;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public TipoSeguroEnum getTipoSeguroEnum() {
        return tipoSeguroEnum;
    }

    public void setTipoSeguroEnum(TipoSeguroEnum tipoSeguroEnum) {
        this.tipoSeguroEnum = tipoSeguroEnum;
    }

    public List<Bem> getListaDeBens() {
        return listaDeBens;
    }

    public void setListaDeBens(List<Bem> listaDeBens) {
        this.listaDeBens = listaDeBens;
    }
}
