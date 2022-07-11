package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.model.ClienteModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Table(name = "cliente")
@Entity
@NoArgsConstructor
public class Cliente extends PessoaFisica {

    private String email;

    public Cliente(final String nome,
                   final LocalDate niver,
                   final String cpf,
                   final String email) {
        super(nome, niver, cpf);
        this.email = email;
    }

    public Cliente(ClienteModel model) {
        super(model.getNome(), model.getNiver(), model.getCpf());
        this.email = email;
    }
    public Cliente editar(final String nome,
                          final LocalDate niver,
                          final String cpf,
                          final String email) {
        super.editar(nome, niver, cpf);
        this.email = email;
        return this;
    }


}
