package com.fiap.banco.api.conta;

import com.fiap.banco.domain.Conta;
import com.fiap.banco.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping
    public List<ContaResponse> listar() {
        return service.listar().stream()
                .map(c -> new ContaResponse(
                        c.getId(), c.getNumero(), c.getAgencia(), c.getCpf(), c.getNome(),
                        c.getTipoDeConta(), c.getEndereco(), c.getSaldo()
                ))
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaResponse inserir(@Valid @RequestBody ContaRequest req) {
        Conta conta = service.novaConta(
                req.getId(),
                req.getNumero(),
                req.getAgencia(),
                req.getCpf(),
                req.getNome(),
                req.getTipoDeConta(),
                req.getEndereco(),
                req.getSaldo(),
                req.getUsuarioId() != null ? req.getUsuarioId() : 1L
        );
        service.salvar(conta);
        return new ContaResponse(
                conta.getId(), conta.getNumero(), conta.getAgencia(), conta.getCpf(), conta.getNome(),
                conta.getTipoDeConta(), conta.getEndereco(), conta.getSaldo()
        );
    }
}
