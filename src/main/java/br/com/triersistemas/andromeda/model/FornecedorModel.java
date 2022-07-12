package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;
@NoArgsConstructor
@Getter
public class FornecedorModel {
    @Id
    private UUID id;
    private String nome;
    private LocalDate niver;
    private String cnpj;

    public FornecedorModel(Fornecedor model) {
        this.id = getId();
        this.nome = nome;
        this.niver = niver;
        this.cnpj = cnpj;
    }
}
