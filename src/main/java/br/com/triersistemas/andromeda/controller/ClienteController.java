package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ClienteModel;
import br.com.triersistemas.andromeda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/consultar")
    public List<Cliente> consultar() {
        return clienteService.consultar();
    }

    @GetMapping("/consultar")
    public Cliente consultarId(@PathVariable UUID id) {
        return clienteService.consultarId(id);
    }

    @PostMapping("/cadastrar")
    public Cliente cadastrar(@RequestBody ClienteModel model) {
        return clienteService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Cliente alterar(@PathVariable UUID id, @RequestBody ClienteModel model) {
        return clienteService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Cliente remover(@PathVariable UUID id) {
        return clienteService.remover(id);
    }
}
