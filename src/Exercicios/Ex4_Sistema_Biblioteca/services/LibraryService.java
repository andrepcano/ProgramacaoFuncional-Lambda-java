package Exercicios.Ex4_Sistema_Biblioteca.services;

import Exercicios.Ex4_Sistema_Biblioteca.entities.Item;

import java.util.List;
import java.util.Objects;

public class LibraryService {

    public static <T extends Comparable<? super T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("List cant be empty");
        }

        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static double totalPrice(List<? extends Item> list) {
        return list.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    public static void expensiveItems(List<? extends Item> list, double value) {
        list.stream()
                .filter(item -> item.getPrice() > value)
                .forEach(System.out::println);
    }

    public static void showTitles(List<? extends Item> list) {
        list.stream()
                .map(Item::getTitle)
                .forEach(System.out::println);
    }
}
