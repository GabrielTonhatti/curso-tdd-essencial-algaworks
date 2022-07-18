package com.algaworks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PedidoTest {

    private PedidoBuilder pedido;

    @Before
    public void setup() {
        pedido = new PedidoBuilder();
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() {
        double valorTotal = 0.0;
        double desconto = 0.0;

        assertResumoDoPedido(valorTotal, desconto);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() {
        pedido.comItem(5.0, 5);
        assertResumoDoPedido(25.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaDoisItensSemDesconto() {
        pedido
                .comItem(3.0, 3)
                .comItem(7.0, 3);

        assertResumoDoPedido(30.0, 0.0);
    }

    @Test
    public void deveAplicarDescontoNa1aFaixa() {
        pedido.comItem(20.0, 20);

        assertResumoDoPedido(400.0, 16.0);
    }

    @Test
    public void deveAplicarDescontoNa2aFaixa() {
        pedido
                .comItem(15.0, 30)
                .comItem(15.0, 30);

        assertResumoDoPedido(900.0, 54.0);
    }

    @Test
    public void deveAplicarDescontoNa3aFaixa() {
        pedido
                .comItem(15.0, 30)
                .comItem(15.0, 30)
                .comItem(10.0, 30);

        assertResumoDoPedido(1200.0, 96.0);
    }

    private void assertResumoDoPedido(double valorTotal, double desconto) {
        ResumoPedido resumoPedido = pedido.construir().resumo();

        assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
    }

}
