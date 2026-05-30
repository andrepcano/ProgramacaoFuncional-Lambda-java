package Exercicios.Ex7_Gerenciamento_Corrida.entities;

import java.util.ArrayList;
import java.util.List;

public class Prova<T> {

    List<T> participantes = new ArrayList<>();

    public List<T> listar() {
        return participantes;
    }

    public void adicionar(T participante) {
        participantes.add(participante);
    }
}
