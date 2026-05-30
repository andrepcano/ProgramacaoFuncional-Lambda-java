package Exercicios.Ex7_Gerenciamento_Corrida.services;

import Exercicios.Ex7_Gerenciamento_Corrida.entities.Participante;

import java.util.Comparator;
import java.util.List;

public class ProvaService {

    public List<Participante> ordenarPeloTempoMD(List<Participante> participantes) {
        return participantes.stream()
                .sorted(Comparator.comparing(Participante::getTempoMedioKM))
                .toList();
    }

    public List<Participante> paisEspecifico(List<Participante> participantes, String pais) {
        return participantes.stream()
                .filter(p -> p.getPaís().equals(pais))
                .toList();
    }

    public Double mediaGeralTempo(List<Participante> participantes) {
        return participantes.stream()
                .mapToInt(p -> p.getTempoMedioKM())
                .average()
                .orElse(0.0);
    }

    public static <T extends Comparable<? super T>> T max(List<T> participantes) {
        if (participantes.isEmpty()) {
            throw new IllegalStateException("Lista não pode ser vazia!");
        }
        T maior = participantes.get(0);
        for (T item : participantes) {
            if (item.compareTo(maior) > 0) {
                maior = item;
            }
        }

        return maior;
    }

    public List<Participante> filtAcimaDe(List<Participante> participantes, Integer minTempoMedio) {
        return participantes.stream()
                .filter(p -> p.getTempoMedioKM() > minTempoMedio)
                .toList();
    }
}
