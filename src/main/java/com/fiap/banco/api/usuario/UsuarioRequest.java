package com.fiap.banco.api.usuario;

import com.fiap.banco.domain.TipoDeUsuarioEnum;
import jakarta.validation.constraints.*;

public class UsuarioRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotNull
    private TipoDeUsuarioEnum tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoDeUsuarioEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeUsuarioEnum tipo) {
        this.tipo = tipo;
    }
}
