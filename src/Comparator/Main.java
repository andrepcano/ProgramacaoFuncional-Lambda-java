package Comparator;

import Comparator.entities.Product;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Iphone", 1900.0));
        list.add(new Product("Macbook", 5000.0));

        /*1° forma
        list.sort(new MyComparator());*/

        /*2° forma
        Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }
        };
        list.sort(comp);*/

        /*3° forma
        Comparator<Product> comp = (p1, p2) -> {
            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        };
        list.sort(comp);*/

        /*4° forma (por ser so uma linha)
        Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        list.sort(comp);*/

        /*5° forma
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));*/


        for (Product product : list) {
            System.out.println(product);
        }

    }
}