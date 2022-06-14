package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ClienteModel;
import br.com.triersistemas.andromeda.repository.ClienteRepository;
import br.com.triersistemas.andromeda.repository.impl.ClienteRepositoryImpl;
import br.com.triersistemas.andromeda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;




@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> consultar() {
        return clienteRepository.pegarTodosDoPote();
    }

    @Override
    public Cliente consultarId(UUID id) {
        return clienteRepository.pegarDoPote();
    }

    @Override
    public Cliente cadastrar(ClienteModel model) {
        Cliente cliente = new Cliente(model.getNome(), model.getNiver(), model.getCpf(), model.getEmail());
        clienteRepository.enfiarNoPote(cliente);
        return cliente;
    }

    @Override
    public Cliente cadastrarRandom() {
        Cliente cliente = new Cliente();
        clienteRepository.enfiarNoPote();
        return cliente;
    }

    @Override
    public Cliente alterar(UUID id, ClienteModel model) {
        Cliente cliente = this.consultarId(id);
        cliente.editar(model.getNome(), model.getNiver(), model.getCpf(), model.getEmail());
        return cliente;
    }

    @Override
    public Cliente remover(UUID id) {
        Cliente cliente = this.consultarId(id);
        clienteRepository.jogarParaForaDoPote(cliente);
        return cliente;
    }

}
