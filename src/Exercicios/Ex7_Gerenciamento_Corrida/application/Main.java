package Exercicios.Ex7_Gerenciamento_Corrida.application;

import Exercicios.Ex7_Gerenciamento_Corrida.entities.Participante;
import Exercicios.Ex7_Gerenciamento_Corrida.entities.Prova;
import Exercicios.Ex7_Gerenciamento_Corrida.services.ProvaService;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Prova<Participante> participanteProva = new Prova<>();

        System.out.println("Quantos participantes quer adicionar?");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Participante #" + i);
            System.out.println("Nome: ");
            String nome = sc.next();
            sc.nextLine();
            System.out.println("País: ");
            String pais = sc.next();
            sc.nextLine();
            System.out.println("Tempo Médio Correndo: ");
            int tempoMedioCorrendo = sc.nextInt();
            sc.nextLine();
            System.out.println("Quantidade de corridas completas: ");
            int qntdCorridasCompletas = sc.nextInt();
            sc.nextLine();

            Participante participante = new Participante(nome, pais, tempoMedioCorrendo, qntdCorridasCompletas);
            participanteProva.adicionar(participante);
        }

        System.out.println("========================\n" +
                "      PARTICIPANTES\n" +
                "========================\n");

        for (Participante p : participanteProva.listar()) {
            System.out.println(p);
        }

        System.out.println("\nORDENADOS PELO TEMPO MÈDIO: \n");
        ProvaService ps = new ProvaService();
        List<Participante> ordenadoTempoMedio = ps.ordenarPeloTempoMD(participanteProva.listar());
        ordenadoTempoMedio.forEach(System.out::println);

        System.out.println("Que país quer filtrar: ");
        String paisEspecifico = sc.next();

        System.out.println("\nPARTICIPANTES DE " + paisEspecifico + "\n");
        ps.paisEspecifico(participanteProva.listar(), paisEspecifico)
                .forEach(System.out::println);

        System.out.println("\nMÉDIA GERAL:\n");
        Double mediaGeral = ps.mediaGeralTempo(participanteProva.listar());
        System.out.println(mediaGeral);

        System.out.println("\nPARTICIPANTE COM MAIS CORRIDAS COMPLETADAS:\n");
        Participante campeao =
                ProvaService.max(participanteProva.listar());

        System.out.println(campeao);

        System.out.println("A partir de qual tempo quer filtrar: ");
        int filtrarTempo = sc.nextInt();

        System.out.println("\nPARTICIPANTES FILTRADOS POR TEMPO:\n");
        ps.filtAcimaDe(participanteProva.listar(), filtrarTempo).forEach(System.out::println);






    sc.close();
    }
}
