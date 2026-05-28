package Exercicios.Ex4_Sistema_Biblioteca.application;

import Exercicios.Ex4_Sistema_Biblioteca.entities.Book;
import Exercicios.Ex4_Sistema_Biblioteca.entities.Item;
import Exercicios.Ex4_Sistema_Biblioteca.entities.Magazine;
import Exercicios.Ex4_Sistema_Biblioteca.services.LibraryService;

import java.awt.font.ImageGraphicAttribute;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Item> list = new ArrayList<>();

        System.out.println("===== LIBRARY SYSTEM =====");
        System.out.println("How many items do you want to add?");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.print("Book opr Magazine (B/M)?: ");
            char ch = Character.toUpperCase(sc.nextLine().charAt(0));

            if (ch == 'B') {
                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                System.out.print("Author: ");
                String author = sc.nextLine();

                System.out.println("----------------------------------");

                Book book = new Book(title, price, author);
                list.add(book);
            }

            else if (ch == 'M') {
                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Edition: ");
                int edition = sc.nextInt();
                sc.nextLine();

                System.out.println("----------------------------------");

                Magazine magazine = new Magazine(title, price, edition);
                list.add(magazine);
            }

        }

        Item valueMax = LibraryService.max(list);

        System.out.println("\n============================");
        System.out.println("\nMOST EXPENSIVE ITEM: " + valueMax);



        System.out.println("\n============================");
        System.out.println("\nALL ITEMS: \n");
        LibraryService.printList(list);


        System.out.print("\nWhat price do you want to filter?: ");
        double value = sc.nextDouble();

        System.out.println("\n============================");
        System.out.println("\nITEMS OVER: " + value + "\n");
        LibraryService.expensiveItems(list, value);

        System.out.println("\n============================");
        System.out.println("\nONLY TITLES: \n");
        LibraryService.showTitles(list);


        sc.close();
    }
}
