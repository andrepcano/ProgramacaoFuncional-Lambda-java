package Exercicios.Ex3_Sistema_Pedidos;

import Exercicios.Ex3_Sistema_Pedidos.entities.Categoria;
import Exercicios.Ex3_Sistema_Pedidos.entities.Pedido;
import Exercicios.Ex3_Sistema_Pedidos.entities.Produto;
import Exercicios.Ex3_Sistema_Pedidos.interfaces.Desconto;
import Exercicios.Ex3_Sistema_Pedidos.services.ProdutoServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();

        Pedido<Produto> pedido = new Pedido<>();

        ProdutoServico produtoServico = new ProdutoServico();

        System.out.print("Quantos produtos serão cadastrados? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nProduto #" + i);

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            System.out.println("Categorias disponíveis:");

            for (Categoria c : Categoria.values()) {
                System.out.println(c);
            }

            System.out.print("Categoria: ");
            String cat = sc.nextLine();

            Categoria categoria = Categoria.valueOf(cat.toUpperCase());

            Produto produto = new Produto(nome, preco, categoria);

            produtos.add(produto);
        }

        System.out.print("\nPorcentagem de desconto: ");
        double qntDesconto = sc.nextDouble();

        System.out.print("Qual valor mínimo deseja filtrar? ");
        double valorMin = sc.nextDouble();

        // adicionando produtos no pedido
        for (Produto p : produtos) {
            pedido.adicionarItem(p);
        }

        // calculando total
        double total = produtoServico.calculoTotal(produtos);

        // lambda desconto
        Desconto desconto = valor -> valor - (valor * qntDesconto / 100);

        // total com desconto
        double totalComDesconto = pedido.aplicarDesconto(total, desconto);

        // exibindo itens
        System.out.println("\n=== ITENS DO PEDIDO ===\n");

        pedido.listarItens();

        // total
        System.out.println("\n=== TOTAL DO PEDIDO ===\n");

        System.out.println("Valor total gasto: R$" + total);

        // produtos caros
        System.out.println("\n=== PRODUTOS ACIMA DE R$" + valorMin + " ===\n");

        List<Produto> caros = produtoServico.produtosCaros(produtos, valorMin);

        for (Produto p : caros) {
            System.out.println(p);
        }

        // ordenando
        produtoServico.ordenarPrecos(produtos);

        System.out.println("\n=== PRODUTOS ORDENADOS POR PREÇO ===\n");

        for (Produto p : produtos) {
            System.out.println(p);
        }

        // desconto
        System.out.println("\n=== TOTAL COM DESCONTO DE " + qntDesconto + "% ===\n");

        System.out.println("R$" + totalComDesconto);

        sc.close();
    }
}