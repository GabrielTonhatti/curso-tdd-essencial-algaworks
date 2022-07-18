package com.algaworks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PedidoTest {

    private Pedido pedido;

    @Before
    public void setup() {
        pedido = new Pedido();
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() {
        double valorTotal = 0.0;
        double desconto = 0.0;

        assertResumoDoPedido(valorTotal, desconto);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
        assertResumoDoPedido(25.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaDoisItensSemDesconto() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
        pedido.adicionarItem(new ItemPedido("Pasta dental", 7.0, 3));

        assertResumoDoPedido(30.0, 0.0);
    }

    @Test
    public void deveAplicarDescontoNa1aFaixa() {
        pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));

        assertResumoDoPedido(400.0, 16.0);
    }

    @Test
    public void deveAplicarDescontoNa2aFaixa() {
        pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));

        assertResumoDoPedido(900.0, 54.0);
    }

    @Test
    public void deveAplicarDescontoNa3aFaixa() {
        pedido.adicionarItem(new ItemPedido("Creme", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Shampoo", 10.0, 30));

        assertResumoDoPedido(1200.0, 96.0);
    }

    private void assertResumoDoPedido(double valorTotal, double desconto) {
        ResumoPedido resumoPedido = pedido.resumo();
        assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
        assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
    }

}
