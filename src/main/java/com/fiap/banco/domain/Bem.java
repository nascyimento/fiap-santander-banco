package com.fiap.banco.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Bem {

    private Long id;
    private TipoDoBemEnum tipoDoBemEnum;
    private String indentificacao;
    private BigDecimal avaliacaoDoBem;

    public Bem(TipoDoBemEnum tipoDoBemEnum, String indentificacao, BigDecimal avaliacaoDoBem) {
        this.tipoDoBemEnum = tipoDoBemEnum;
        this.indentificacao = indentificacao;
        this.avaliacaoDoBem = avaliacaoDoBem;
    }

    public Bem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDoBemEnum getTipoDoBemEnum() {
        return tipoDoBemEnum;
    }

    public void setTipoDoBemEnum(TipoDoBemEnum tipoDoBemEnum) {
        this.tipoDoBemEnum = tipoDoBemEnum;
    }

    public String getIndentificacao() {
        return indentificacao;
    }

    public void setIndentificacao(String indentificacao) {
        this.indentificacao = indentificacao;
    }

    public BigDecimal getAvaliacaoDoBem() {
        return avaliacaoDoBem;
    }

    public void setAvaliacaoDoBem(BigDecimal avaliacaoDoBem) {
        this.avaliacaoDoBem = avaliacaoDoBem;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bem bem = (Bem) o;
        return Objects.equals(id, bem.id) && tipoDoBemEnum == bem.tipoDoBemEnum && Objects.equals(indentificacao, bem.indentificacao) && Objects.equals(avaliacaoDoBem, bem.avaliacaoDoBem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoDoBemEnum, indentificacao, avaliacaoDoBem);
    }

    @Override
    public String toString() {
        return "Bem{" +
                "id=" + id +
                ", tipoDoBemEnum=" + tipoDoBemEnum +
                ", indentificacao='" + indentificacao + '\'' +
                ", avaliacaoDoBem=" + avaliacaoDoBem +
                '}';
    }
}
