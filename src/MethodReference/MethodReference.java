package MethodReference;

import Comparator.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {

        public static int compareProducts(Product p1, Product p2) {
            return p1.getPrice().compareTo(p2.getPrice());
        }

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Iphone", 1900.0));
        list.add(new Product("Macbook", 5000.0));

        list.sort(MethodReference::compareProducts);

        list.forEach(System.out::println);
    }
}
