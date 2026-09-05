package com.cafeteria.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Startup
public class CardapioBean {
    private Map<String, Double> produtos = new HashMap<>();

    @PostConstruct
    public void inicializarCardapio() {
        produtos.put("Cafe Expresso", 6.50);
        produtos.put("Cappuccino", 9.00);
        produtos.put("Pao de Queijo", 5.00);
        produtos.put("Bolo de Cenoura", 8.50);
    }

    public Double obterPreco(String produto) { return produtos.get(produto); }
    public Map<String, Double> listarProdutos() { return produtos; }
}
