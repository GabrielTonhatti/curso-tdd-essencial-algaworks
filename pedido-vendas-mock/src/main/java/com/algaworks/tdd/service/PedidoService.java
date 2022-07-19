package com.algaworks.tdd.service;

import com.algaworks.tdd.model.Pedido;
import com.algaworks.tdd.model.StatusPedido;
import com.algaworks.tdd.repository.Pedidos;

import java.util.List;

public class PedidoService {

    private final Pedidos pedidos;
    private final List<AcaoLancamentoPedido> acoes;

    public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {
        this.pedidos = pedidos;
        this.acoes = acoes;
    }

    public double lancar(Pedido pedido) {
        double imposto = pedido.getValor() * 0.1;

        pedidos.guardar(pedido);
        acoes.forEach(acao -> acao.executar(pedido));

        return imposto;
    }

    public Pedido pagar(Long codigo) {
        Pedido pedido = pedidos.buscarPeloCodigo(codigo);

        if (!pedido.getStatus().equals(StatusPedido.PENDENTE)) {
            throw new StatusPedidoInvalidoException();
        }

        pedido.setStatus(StatusPedido.PAGO);
        return pedido;
    }
}
