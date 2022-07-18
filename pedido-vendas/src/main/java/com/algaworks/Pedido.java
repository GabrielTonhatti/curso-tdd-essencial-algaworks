package com.algaworks;

import com.algaworks.desconto.CalculadoraFaixaDesconto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<ItemPedido> itens = new ArrayList<>();
    private final CalculadoraFaixaDesconto calculadoraFaixaDesconto;

    public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
        this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        this.itens.add(itemPedido);
    }

    public ResumoPedido resumo() {
        double valorTotal = itens
                .stream()
                .mapToDouble(item -> item.getValorUnitario() * item.getQuantidade())
                .sum();
        double desconto = calculadoraFaixaDesconto.desconto(valorTotal);

        return new ResumoPedido(valorTotal, desconto);
    }
}
