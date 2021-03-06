package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import br.com.triersistemas.andromeda.model.ProdutoModel;
import br.com.triersistemas.andromeda.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/consultar")
    public List<ProdutoModel> consultar() {
        return produtoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public ProdutoModel consultar(@PathVariable UUID id, @RequestBody ProdutoModel model) {
        return produtoService.consultar(id);
    }

    @GetMapping("/consultar/{ids}")
    public List<ProdutoModel> consultar(@PathVariable List<UUID> ids) {
        return produtoService.consultar(ids);
    }
    @PostMapping("/cadastrar")
    public ProdutoModel cadastrar(@RequestBody ProdutoModel model) {
        return produtoService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public ProdutoModel alterar(@RequestBody @PathVariable ProdutoModel model) {
        return produtoService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public ProdutoModel remover(@PathVariable UUID id) {
        return produtoService.remover(id);
    }
}
