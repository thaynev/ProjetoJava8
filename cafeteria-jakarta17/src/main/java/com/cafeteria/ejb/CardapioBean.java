package com.cafeteria.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.util.Map;

@Singleton
@Startup
public class CardapioBean {
    private Map<String, Double> produtos;

    @PostConstruct
    public void inicializarCardapio() {
        produtos = Map.of(
                "Cafe Expresso", 6.50,
                "Cappuccino", 9.00,
                "Pao de Queijo", 5.00,
                "Bolo de Cenoura", 8.50
        );
    }

    public Double obterPreco(String produto) { return produtos.get(produto); }
    public Map<String, Double> listarProdutos() { return produtos; }
}
