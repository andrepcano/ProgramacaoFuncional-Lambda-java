package Exercicios.Ex5_Sistema_Pontuacao_Jogos.entities;

import java.util.ArrayList;
import java.util.List;

public class Sala<T> {

    private List<T> jogadores = new ArrayList<>();

    public void adicionar(T jogador) {
        jogadores.add(jogador);
    }

    public void remover(T jogador) {
        jogadores.remove(jogador);
    }

    public List<T> listar() {
        return jogadores;
    }
}
