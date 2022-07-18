package com.algaworks;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido itemPedido) {
        this.itens.add(itemPedido);
    }

    public ResumoPedido resumo() {
        double valorTotal = itens
                .stream()
                .mapToDouble(item -> item.getValorUnitario() * item.getQuantidade())
                .sum();
        double desconto = 0.0;

        if (valorTotal > 300 && valorTotal <= 800) {
            desconto = valorTotal * 0.04;
        } else if (valorTotal > 800 && valorTotal <= 1000) {
            desconto = valorTotal * 0.06;
        } else if (valorTotal > 1000) {
            desconto = valorTotal * 0.08;
        }

        return new ResumoPedido(valorTotal, desconto);
    }
}
