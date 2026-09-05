package com.cafeteria.api;

import com.cafeteria.ejb.*;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/cafeteria")
public class CafeteriaController {
    @EJB private CardapioBean cardapio;
    @EJB private CarrinhoBean carrinho;
    @EJB private PedidoBean processadorPedido;

    @GET
    @Path("/simular")
    @Produces(MediaType.TEXT_PLAIN)
    public String simularAtendimento() {
        var res = new StringBuilder("--- PROJETO JAVA 17 ---\n\n");
        res.append("1. Cardapio:\n");
        cardapio.listarProdutos().forEach((n, p) -> res.append(" - ").append(n).append(": R$ ").append(p).append("\n"));
        carrinho.adicionarItem("Cafe Expresso");
        carrinho.adicionarItem("Pao de Queijo");
        res.append("\n2. Carrinho: ").append(carrinho.obterItens()).append("\n");
        double total = processadorPedido.finalizarPedido(carrinho.obterItens());
        res.append("\n3. Pedido Finalizado! Total: R$ ").append(total).append("\n");
        carrinho.esvaziar();
        return res.toString();
    }
}
