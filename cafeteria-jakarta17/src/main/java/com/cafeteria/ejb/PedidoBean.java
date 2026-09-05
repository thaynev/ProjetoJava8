package com.cafeteria.ejb;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class PedidoBean {
    @EJB private CardapioBean cardapio;

    public double finalizarPedido(List<String> itens) {
        if (itens == null || itens.isEmpty()) return 0.0;
        return itens.stream()
                .mapToDouble(item -> cardapio.obterPreco(item) != null ? cardapio.obterPreco(item) : 0.0)
                .sum();
    }
}
