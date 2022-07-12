package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

@Getter
@Entity
@Table(name = "produto")
public class Fornecedor extends PessoaJuridica {


 @ManyToMany
 @JoinTable(
         joinColumns = @JoinColumn(columnDefinition = "fornecedor_id", referencedColumnName = "id"),
         inverseJoinColumns = @JoinColumn(columnDefinition = "produto_id", referencedColumnName = "id")
 )
    private List<String> produtos;

    public Fornecedor() {
        this.produtos = getProdutos();
    }

    public Fornecedor(final String nome, final LocalDate niver, final String cnpj) {
        super(nome, niver, cnpj);
        this.produtos = getProdutos();
    }

    public List<String> getProdutos() {
        return produtos;
    }
}
