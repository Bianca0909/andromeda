package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ClienteModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private static final List<Cliente> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Cliente> consultar() {
        return LIST;
    }

    @GetMapping("/consultar")
    public List<Cliente> consultarId(@PathVariable UUID id, @RequestBody ClienteModel model) {
        return (List<Cliente>) LIST.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(NaoExisteException::new);
    }

    @PostMapping("/cadastrar")
    public Cliente cadastrar(@RequestBody ClienteModel model) {
        var cliente = new Cliente(model.getNome(), model.getNiver(), model.getCpf(), model.getEmail());
        LIST.add(cliente);
        return cliente;
    }


    @PutMapping("/alterar/{id}")
    public Cliente alterar(@PathVariable UUID id, @RequestBody ClienteModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        return (Cliente) domain.editar(model.getNome(), model.getNiver(), model.getCpf());

    }

    @DeleteMapping("/remover/{id}")
    public Cliente remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return domain;
    }
}































































