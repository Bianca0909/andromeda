package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import br.com.triersistemas.andromeda.model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface FarmaceuticoService {
    List<Farmaceutico> consultar();

    Farmaceutico consultar(UUID id);


    Farmaceutico cadastrar(FarmaceuticoModel model);

    Farmaceutico alterar(UUID id, ProdutoModel model);

    Farmaceutico remover(UUID id);
}
