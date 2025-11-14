package com.fiap.banco.service;

import com.fiap.banco.domain.Conta;
import com.fiap.banco.domain.TipoContaEnum;
import com.fiap.banco.domain.Usuario;
import com.fiap.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listar() {
        return contaRepository.findAll();
    }

    public void salvar(Conta conta) {
        contaRepository.save(conta);
    }

    public Conta novaConta(Integer id, Integer numero, String agencia, String cpf, String nome,
                           TipoContaEnum tipo,
                           String endereco, java.math.BigDecimal saldo, Long usuarioId) {
        return new Conta(id, numero, agencia, cpf, nome, tipo, endereco, saldo, new Usuario(usuarioId));
    }
}
