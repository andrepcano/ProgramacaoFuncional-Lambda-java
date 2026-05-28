package Exercicios.Ex4_Sistema_Biblioteca.entities;

import Exercicios.Ex4_Sistema_Biblioteca.services.Fineable;

public class Magazine extends Item implements Fineable {
    private Integer edition;

    public Magazine(String title, Double price, Integer edition) {
        super(title, price);
        this.edition = edition;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    @Override
    public double calculateFine() {
        return getPrice() * 0.02;
    }
}
