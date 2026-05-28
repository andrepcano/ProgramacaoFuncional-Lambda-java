package Exercicios.Ex4_Sistema_Biblioteca.entities;

import java.util.Comparator;

public abstract class Item implements Comparable<Item> {
    private String title;
    private Double price;

    public Item(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Item other) {
        return price.compareTo(other.getPrice());
    }

    @Override
    public String toString() {
        return title + ", $" + price;
    }
}
