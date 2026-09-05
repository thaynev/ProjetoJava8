![Build Status](https://github.com/thaynev/cafeteria-ejb-portfolio/actions/workflows/build.yml/badge.svg)0
# ☕ Cafeteria EJB Architecture Comparison (Java 8 vs Java 17)

Este repositório demonstra o domínio sobre componentes corporativos **EJB (Enterprise JavaBeans)**, comparando as duas principais eras do desenvolvimento corporativo em Java: o ambiente legado corporativo (*Java EE 8 / Java 8*) e o ecossistema moderno unificado (*Jakarta EE 10 / Java 17*).

## 🏢 Arquitetura do Sistema
O sistema aplica os escopos de ciclo de vida clássicos do EJB para gerenciar o fluxo de uma cafeteria:
1. **`CardapioBean` (`@Singleton`):** Carregado uma única vez ao iniciar a aplicação. Centraliza a tabela de preços global.
2. **`CarrinhoBean` (`@Stateful`):** Mantém o estado da sessão de compras isolado por cliente na memória do servidor de aplicação.
3. **`PedidoBean` (`@Stateless`):** Processa o fechamento da conta de forma rápida e concorrente através do pool otimizado do servidor.

## 🛠️ Como Compilar
Acesse a pasta da versão desejada e use o Maven:
```bash
mvn clean package
```
