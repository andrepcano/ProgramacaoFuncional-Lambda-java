package InterfacesFuncionais.Consumer.entities;

import InterfacesFuncionais.Predicate.entities.Product3;

public class Product4 {
    private String name;
    private Double price;

    public Product4(String name, Double price) {
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
    public static void staticPiceUpdate(Product4 p) {
        p.setPrice(p.getPrice() * 1.1);
    }

    public void nonStaticPiceUpdate() {
        setPrice(getPrice() * 1.1);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
