package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    @Query(value = "SELECT * FROM produto p " +
            "JOIN pedido_produto pp ON p.id = pp.produto_id " +
            "WHERE pp.pedido_id = ?1", nativeQuery = true)
        List<ProdutoModel> buscarPorpedido(UUID idPedido);
    }


