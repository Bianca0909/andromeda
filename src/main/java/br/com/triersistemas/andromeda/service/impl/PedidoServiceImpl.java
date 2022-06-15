package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Pedido;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.PedidoModel;
import br.com.triersistemas.andromeda.repository.PedidoRepository;
import br.com.triersistemas.andromeda.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> consultar() {
        return pedidoRepository.pegarTodosDoPote();
    }

    @Override
    public Pedido consultar(UUID id) {
        return pedidoRepository.pegarDoPote(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Pedido cadastrar(PedidoModel model) {
        Pedido pedido = new Pedido(model.getIdCliente(), model.getIdFarmaceutico());
        pedidoRepository.enfiarNoPote(pedido);
        return pedido;
    }


    @Override
    public Pedido alterar(UUID id, PedidoModel model) {
        Pedido pedido = this.consultar(id);
        pedido.editar(model.getIdCliente(), model.getIdFarmaceutico());
        return pedido;
    }

    @Override
    public Pedido remover(UUID id) {
        Pedido pedido = this.consultar(id);
        pedidoRepository.jogarParaForaDoPote(pedido);
        return pedido;
}}
