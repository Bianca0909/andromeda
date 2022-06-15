package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.model.ClienteModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public interface ClienteService {

    List<Cliente> consultar();

    Cliente consultarId(UUID id);

    Cliente cadastrar(ClienteModel model);

    Cliente alterar(UUID id, ClienteModel model);

    Cliente remover(UUID id);
}
