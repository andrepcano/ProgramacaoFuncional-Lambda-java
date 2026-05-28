package Exercicios.Ex5_Sistema_Pontuacao_Jogos.services;

import Exercicios.Ex5_Sistema_Pontuacao_Jogos.entities.Jogador;

import java.util.Comparator;
import java.util.List;

public class RankingService {
    public List<Jogador> ordenarRanking(List<Jogador> jogadores) {
        return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getPontuacao).reversed())
                .toList();
    }

    public Integer pontuacaoTotal(List<Jogador> jogadores) {
        return jogadores.stream()
                .mapToInt(jogador -> jogador.getPontuacao())
                .sum();
    }

    public List<Jogador> jogadoresAcima(List<Jogador> jogadores, Integer pontos) {
        jogadores.stream()
                .filter(jogador -> jogador.getPontuacao() > pontos)
                .toList();
        return jogadores;
    }

    public static <T extends Comparable<? super T>> T max(List<T> jogadores) {
        if (jogadores.isEmpty()) {
            throw new IllegalStateException("Lista nao pode ser vazia");
        }

        T max = jogadores.get(0);
        for (T item : jogadores) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }
}
