package br.com.triersistemas.andromeda.domain;

import org.apache.tomcat.jni.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private Cliente idCliente;
    private Farmaceutico idFarmaceutico;
    private Produto id;
    private List<Produto> produtos;
    private BigDecimal valor;
    private UUID idPedido;
    private LocalDateTime dataPedido;
    private LocalDateTime dataPagamento;
    private BigDecimal valorPago;
    private BigDecimal troco;

    public Pedido(final Cliente idClente, final LocalDate id, final String cpf, final String email) {


    }

    public Pedido() {

    }

    public Produto Pedido(final String nome, final LocalDate niver, final String cpf, final String email) {
return null;
    }
}