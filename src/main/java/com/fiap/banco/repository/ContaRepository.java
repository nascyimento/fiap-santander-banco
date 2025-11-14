package com.fiap.banco.repository;

import com.fiap.banco.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
    List<Conta> findByAgencia(String agencia);

    List<Conta> findByCpf(String cpf);
}
