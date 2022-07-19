package com.algaworks.tdd.service;

import com.algaworks.tdd.email.NotificadorEmail;
import com.algaworks.tdd.model.Pedido;
import com.algaworks.tdd.repository.Pedidos;
import com.algaworks.tdd.sms.NotificadorSms;

public class PedidoService {

    private final Pedidos pedidos;
    private final NotificadorEmail notificadorEmail;
    private final NotificadorSms notificadorSms;

    public PedidoService(Pedidos pedidos, NotificadorEmail notificadorEmail, NotificadorSms notificadorSms) {
        this.pedidos = pedidos;
        this.notificadorEmail = notificadorEmail;
        this.notificadorSms = notificadorSms;
    }

    public double lancar(Pedido pedido) {
        double imposto = pedido.getValor() * 0.1;

        pedidos.guardar(pedido);
        notificadorEmail.enviar(pedido);
        notificadorSms.notificar(pedido);

        return imposto;
    }

}
