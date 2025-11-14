package com.fiap.banco.service;

import com.fiap.banco.domain.Usuario;
import com.fiap.banco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> listar() { return repo.findAll(); }

    @Transactional
    public Usuario salvar(Usuario u) {
        // validações simples
        if (repo.existsByEmail(u.getEmail())) throw new IllegalArgumentException("Email já cadastrado");
        if (repo.existsByCpf(u.getCpf())) throw new IllegalArgumentException("CPF já cadastrado");
        return repo.save(u);
    }
}

