package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ProdutoModel;
import br.com.triersistemas.andromeda.repository.ProdutoRepository;
import br.com.triersistemas.andromeda.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> consultar(UUID idProduto) {
        return produtoRepository.pegarTodosDoPote();
    }

    @Override
    public Produto consultarId(UUID id) {
        return produtoRepository.pegarDoPote(id).orElseThrow(NaoExisteException::new);
    }


    @Override
    public Produto cadastrar(ProdutoModel model) {
        Produto produto = new Produto(model.getNome(), model.getValor());
        produtoRepository.enfiarNoPote(produto);
        return produto;
    }

    @Override
    public Produto alterar(UUID id, ProdutoModel model) {
        Produto produto = this.consultarId(id);
        produto.editar(model.getNome(), model.getValor());
        return produto;
    }

    @Override
    public Produto remover(UUID id) {
        Produto produto = this.consultarId(id);
        produtoRepository.jogarParaForaDoPote(produto);
        return produto;
    }
}
