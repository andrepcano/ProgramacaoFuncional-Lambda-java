package InterfacesFuncionais.Consumer;

import InterfacesFuncionais.Consumer.entities.Product4;
import InterfacesFuncionais.Consumer.util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Product4> list = new ArrayList<>();

        list.add(new Product4("Tv", 900.0));
        list.add(new Product4("Iphone", 1900.0));
        list.add(new Product4("Macbook", 5000.0));
        list.add(new Product4("Mouse", 50.0));
        list.add(new Product4("Mousepad", 89.0));

        /*1° forma
        list.forEach(new PriceUpdate());*/

        /*2° forma
        list.forEach(Product4::staticPiceUpdate);*/

        /*3° forma
        list.forEach(Product4::nonStaticPiceUpdate);*/

        /*4° forma
        Consumer<Product4> cons = p -> p.setPrice(p.getPrice() * 1.1);
        list.forEach(cons);*/

        /*5° forma
        list.forEach(p -> p.setPrice(p.getPrice() * 1.1));*/


        // Method Reference para percorrer a lista
        list.forEach(System.out::println);
    }
}
