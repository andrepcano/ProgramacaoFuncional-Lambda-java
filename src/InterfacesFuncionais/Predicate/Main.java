package InterfacesFuncionais.Predicate;

import InterfacesFuncionais.Predicate.entities.Product3;
import InterfacesFuncionais.Predicate.util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Product3> list = new ArrayList<>();

        list.add(new Product3("Tv", 900.0));
        list.add(new Product3("Iphone", 1900.0));
        list.add(new Product3("Macbook", 5000.0));
        list.add(new Product3("Mouse", 50.0));
        list.add(new Product3("Mousepad", 89.0));

        /*1° forma
        list.removeIf(new ProductPredicate());*/

        /*2° forma (Method Reference)
        list.removeIf(Product3::staticProductPredicate);*/

        /*3° forma
        list.removeIf(Product3::nonStaticProductPredicate);*/

        /*4° forma
        double min = 100.0;
        Predicate<Product3> pred = p -> p.getPrice() >= min;

        list.removeIf(pred);*/

        /*5° forma
        list.removeIf( p -> p.getPrice() >= 100.0);*/

        for (Product3 p : list) {
            System.out.println(p);
        }
    }
}
