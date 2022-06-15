package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;


public class Produto {
    private BigDecimal valor;
    private UUID id;
    private String nome;
    private String fornecedor;

    public Produto() {
        this.id = UUID.randomUUID();
        this.nome = StringUtils.getRandomMed();
        this.valor = StringUtils.getRandomValue();

    }

    public Produto(String nome, BigDecimal valor) {
        this.editar(nome, valor);
        this.id = UUID.randomUUID();
    }


    public Produto editar(final String nome, final BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
        return this;
    }

    public UUID getId() {
        return this.id;
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