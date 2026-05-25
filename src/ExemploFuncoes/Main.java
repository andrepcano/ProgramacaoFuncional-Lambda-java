package ExemploFuncoes;


import ExemploFuncoes.entities.Product6;
import ExemploFuncoes.model.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product6> list = new ArrayList<>();

        list.add(new Product6("Tv", 900.0));
        list.add(new Product6("Iphone", 1900.0));
        list.add(new Product6("Macbook", 5000.0));
        list.add(new Product6("Mouse", 50.0));
        list.add(new Product6("Tablet", 550.0));

        ProductService ps = new ProductService();

        // usando (Predicate) como parametro em ProductService
        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');

        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
