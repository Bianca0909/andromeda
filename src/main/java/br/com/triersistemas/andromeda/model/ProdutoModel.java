package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;


@Getter
public class ProdutoModel {

    private UUID id;
    private String nome;
    private BigDecimal valor;

    public ProdutoModel(Produto model) {
        this.id = getId();
        this.nome = nome;
        this.valor = valor;
    }
}
