package com.algaworks.tdd.service;

import com.algaworks.tdd.email.NotificadorEmail;
import com.algaworks.tdd.model.Pedido;
import com.algaworks.tdd.model.builder.PedidoBuilder;
import com.algaworks.tdd.repository.Pedidos;
import com.algaworks.tdd.sms.NotificadorSms;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class PedidoServiceTest {

    private PedidoService pedidoService;

    private Pedido pedido;

    @Mock
    private Pedidos pedidos;

    @Mock
    private NotificadorEmail notificadorEmail;

    @Mock
    private NotificadorSms notificadorSms;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        pedidoService = new PedidoService(pedidos, notificadorEmail, notificadorSms);
        pedido = new PedidoBuilder()
                .comValor(100.0)
                .para("João", "joao@joao.com", "9999-0000")
                .constuir();
    }

    @Test
    public void deveCalcularOImposto() {
        double imposto = pedidoService.lancar(pedido);

        assertEquals(10.0, imposto, 0.00001);
    }

    @Test
    public void deveSalvarPedidoNoBancoDeDados() {
        pedidoService.lancar(pedido);
        verify(pedidos).guardar(pedido);
    }

    @Test
    public void deveNotificarPorEmail() {
        pedidoService.lancar(pedido);
        verify(notificadorEmail).enviar(pedido);
    }

    @Test
    public void deveNotificarPorSms() {
        pedidoService.lancar(pedido);
        verify(notificadorSms).notificar(pedido);
    }

}
