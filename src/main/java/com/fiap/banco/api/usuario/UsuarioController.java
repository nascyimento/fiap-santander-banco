package com.fiap.banco.api.usuario;

import com.fiap.banco.domain.Usuario;
import com.fiap.banco.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) { this.service = service; }

    @GetMapping
    public List<UsuarioResponse> listar() {
        return service.listar().stream()
                .map(u -> new UsuarioResponse(u.getId(), u.getNome(), u.getCpf(), u.getEmail(), u.getTipo()))
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse inserir(@Valid @RequestBody UsuarioRequest req) {
        Usuario u = new Usuario();
        u.setNome(req.getNome());
        u.setCpf(req.getCpf());
        u.setEmail(req.getEmail());
        u.setSenha(req.getSenha());
        u.setTipo(req.getTipo());
        Usuario salvo = service.salvar(u);
        return new UsuarioResponse(salvo.getId(), salvo.getNome(), salvo.getCpf(), salvo.getEmail(), salvo.getTipo());
    }
}

