package Exercicios.Ex5_Sistema_Pontuacao_Jogos.application;

import Exercicios.Ex5_Sistema_Pontuacao_Jogos.entities.Jogador;
import Exercicios.Ex5_Sistema_Pontuacao_Jogos.entities.Partida;
import Exercicios.Ex5_Sistema_Pontuacao_Jogos.entities.Sala;
import Exercicios.Ex5_Sistema_Pontuacao_Jogos.services.RankingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Sala<Jogador> sala = new Sala<>();

        System.out.println("Quer criar quantos jogadores: ");
        int j = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= j; i++ ) {

            System.out.println();
            System.out.println("=== Jogador " + i + " ===");
            System.out.print("Digite o nome do jogador: ");
            String nome = sc.nextLine();

            System.out.print("Digite a pontuação: ");
            int pontuacao = sc.nextInt();

            System.out.print("Digite o nível: ");
            int nivel = sc.nextInt();
            sc.nextLine();

            Jogador jogador = new Jogador(nome, pontuacao, nivel);
            sala.adicionar(jogador);

            System.out.println("Jogador criado!");
        }

        System.out.println("========================\n" +
                "      JOGADORES\n" +
                "========================\n");

        for (int i = 0; i < sala.listar().size(); i++) {
            System.out.println(
                    i + " - " +
                            sala.listar().get(i).getNome()
            );
        }

        System.out.println("Escolha o vencedor: ");
        int escolhaVencedor = sc.nextInt();

        System.out.println("Escolha o perdedor: ");
        int escolhaPerdedor = sc.nextInt();

        Jogador vencedor = sala.listar().get(escolhaVencedor);
        Jogador perdedor = sala.listar().get(escolhaPerdedor);

        Partida partida = new Partida(vencedor, perdedor, 500);
        partida.finalizarPartida();
        System.out.println("Partida Finalizada!");

        RankingService serivce = new RankingService();
        List<Jogador> rankingAtt = serivce.ordenarRanking(sala.listar());

        System.out.println("========================\n" +
                "   RANKING ATUALIZADO\n" +
                "========================");

        for (Jogador jogador : rankingAtt) {
            System.out.println(jogador);
        }

        System.out.println("\nPONTUAÇÂO TOTAL: ");
        Integer pontTot = serivce.pontuacaoTotal(sala.listar());
        System.out.println(pontTot);

        System.out.println("\nQual quantidade de pontos quer filtar: ");
        int minPontos = sc.nextInt();
        sc.nextLine();

        System.out.println("\nJogadores acima de " + minPontos + " pontos");
        List<Jogador> filtrados = serivce.jogadoresAcima(sala.listar(), minPontos);
        System.out.println(filtrados);



        sc.close();
    }
}
