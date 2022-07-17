package com.algaworks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PedidoVendaTest {

    private Pedido pedido;

    @Before
    public void setup() {
        pedido = new Pedido();
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() {
        pedido.adicionarItem("Sabonete", 3.0, 10);
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() {
        double esperado = 0.0;
        assertEquals(esperado, pedido.valorTotal(), 0.0001);
        assertEquals(esperado, pedido.desconto(), 0.0001);
    }

}
