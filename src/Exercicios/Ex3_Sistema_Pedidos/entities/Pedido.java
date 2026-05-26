package Exercicios.Ex3_Sistema_Pedidos.entities;

import Exercicios.Ex3_Sistema_Pedidos.interfaces.Desconto;

import java.util.ArrayList;
import java.util.List;

public class Pedido<T> {

    private List<T> itens = new ArrayList<>();

    public void adicionarItem(T item) {
        itens.add(item);
    }

    public void listarItens() {
        for (T item : itens) {
            System.out.println(item);
        }
    }

    public List<T> getItens() {
        return itens;
    }

    public double aplicarDesconto(double total, Desconto desconto) {
        return desconto.aplicar(total);
    }
}
