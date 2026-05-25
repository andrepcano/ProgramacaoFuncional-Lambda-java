package InterfacesFuncionais.Function;


import InterfacesFuncionais.Function.entities.Product5;
import InterfacesFuncionais.Function.util.UpperCaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product5> list = new ArrayList<>();

        list.add(new Product5("Tv", 900.0));
        list.add(new Product5("Iphone", 1900.0));
        list.add(new Product5("Macbook", 5000.0));
        list.add(new Product5("Mouse", 50.0));
        list.add(new Product5("Mousepad", 89.0));



        /*1° forma
        // (map) aplica uma função a todos os elementos de uma stream
        List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList()); // convertendo pra lista pois a original é com (Product)
        names.forEach(System.out::println);*/

        /*2° forma
        List<String> names = list.stream().map(Product5::staticUpperCaseName).collect(Collectors.toList());
        names.forEach(System.out::println);*/

        /*3° forma
        List<String> names = list.stream().map(Product5::nonStaticUpperCaseName).collect(Collectors.toList());
        names.forEach(System.out::println);*/

        /*4° forma
        Function<Product5, String> func = p -> p.getName().toUpperCase();

        List<String> names = list.stream().map(func).collect(Collectors.toList());
        names.forEach(System.out::println);*/

        /*5° forma
        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
        names.forEach(System.out::println);*/

    }
}
