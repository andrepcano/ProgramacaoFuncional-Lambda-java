package Exercicios.Ex3_Sistema_Pedidos.services;

import Exercicios.Ex3_Sistema_Pedidos.entities.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoServico {

    public void ordenarPrecos(List<Produto> p) {
        p.sort((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()));
    }
    public List<Produto> produtosCaros(List<Produto> produtos, double valorMin) {
        return produtos.stream()
                .filter(p -> p.getPreco() > valorMin)
                .toList();
    }

    public double calculoTotal(List<Produto> produtos) {
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }
}
