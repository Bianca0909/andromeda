package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ProdutoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private static final List<Produto> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Produto> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public List<Produto> cadastrar(@RequestBody ProdutoModel model) {
        LIST.add(new Produto(model.getNome(), model.getValor(), model.getFornecedor()));
        return LIST;
    }

    @PostMapping("/cadastrar-random")
    public List<Produto> cadastrarRandom() {
        LIST.add(new Produto());
        return LIST;
    }

    @PutMapping("/alterar/{id}")
    public List<Produto> alterar(@PathVariable UUID id, @RequestBody ProdutoModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getValor(), model.getFornecedor());
        return LIST;
    }

    @DeleteMapping("/remover/{id}")
    public List<Produto> remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return LIST;
    }
}
