package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {
    private UUID id;
    private String nome;
    private BigDecimal valor;
    private String fornecedor;

    protected Produto(final UUID id, final String nome, final BigDecimal valor, final String fornecedor) {
this.id = UUID.randomUUID();
this.nome = StringUtils.getRandomMed();
this.fornecedor = StringUtils.getRandomName();


    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}