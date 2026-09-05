package com.cafeteria.ejb;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CarrinhoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> itens = new ArrayList<>();

    public void adicionarItem(String produto) { itens.add(produto); }
    public List<String> obterItens() { return itens; }
    public void esvaziar() { itens.clear(); }
}
