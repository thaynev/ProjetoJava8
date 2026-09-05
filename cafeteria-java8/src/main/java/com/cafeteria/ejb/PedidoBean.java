package com.cafeteria.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PedidoBean {
    @EJB
    private CardapioBean cardapio;

    public double finalizarPedido(List<String> itens) {
        if (itens == null || itens.isEmpty()) return 0.0;
        double total = 0.0;
        for (String item : itens) {
            Double preco = cardapio.obterPreco(item);
            if (preco != null) total += preco;
        }
        return total;
    }
}
