package InterfacesFuncionais.Function.entities;

import InterfacesFuncionais.Consumer.entities.Product4;

public class Product5 {
    private String name;
    private Double price;

    public Product5(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // como é (static) precisa de um parametro para usar de referencia
    public static String staticUpperCaseName(Product5 p) {
        return p.getName().toUpperCase();
    }

    public String nonStaticUpperCaseName() {
        return name.toUpperCase();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
