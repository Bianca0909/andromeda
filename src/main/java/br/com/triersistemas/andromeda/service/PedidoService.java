package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Pedido;
import br.com.triersistemas.andromeda.model.PedidoModel;


import java.util.List;
import java.util.UUID;

public interface PedidoService {

    List<Pedido> consultar();

    Pedido consultar(UUID id);

    Pedido cadastrar(PedidoModel model);

    Pedido alterar(UUID id, PedidoModel model);

    Pedido remover(UUID id);



}
