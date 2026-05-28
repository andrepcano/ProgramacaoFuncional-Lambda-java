package Exercicios.Ex4_Sistema_Biblioteca.entities;

import Exercicios.Ex4_Sistema_Biblioteca.services.Fineable;

public class Book extends Item implements Fineable {
    private String author;

    public Book(String title, Double price, String author) {
        super(title, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public double calculateFine() {
        return getPrice() * 0.05;
    }
}
