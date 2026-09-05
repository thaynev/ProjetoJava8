package com.cafeteria.api;

import com.cafeteria.ejb.*;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/cafeteria")
public class CafeteriaController {
    @EJB private CardapioBean cardapio;
    @EJB private CarrinhoBean carrinho;
    @EJB private PedidoBean processadorPedido;

    @GET
    @Path("/simular")
    @Produces(MediaType.TEXT_PLAIN)
    public String simularAtendimento() {
        StringBuilder res = new StringBuilder("--- PROJETO JAVA 8 ---\n\n");
        res.append("1. Cardapio:\n");
        for (Map.Entry<String, Double> entry : cardapio.listarProdutos().entrySet()) {
            res.append(" - ").append(entry.getKey()).append(": R$ ").append(entry.getValue()).append("\n");
        }
        carrinho.adicionarItem("Cafe Expresso");
        carrinho.adicionarItem("Pao de Queijo");
        res.append("\n2. Carrinho: ").append(carrinho.obterItens()).append("\n");
        double total = processadorPedido.finalizarPedido(carrinho.obterItens());
        res.append("\n3. Pedido Finalizado! Total: R$ ").append(total).append("\n");
        carrinho.esvaziar();
        return res.toString();
    }
}
