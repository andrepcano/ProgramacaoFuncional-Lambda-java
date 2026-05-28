package Exercicios.Ex5_Sistema_Pontuacao_Jogos.entities;

import Exercicios.Ex5_Sistema_Pontuacao_Jogos.exceptions.NivelInvalido;
import Exercicios.Ex5_Sistema_Pontuacao_Jogos.exceptions.PontuacaoInvalidaException;
import Exercicios.Ex5_Sistema_Pontuacao_Jogos.interfaces.Notificavel;
import Exercicios.Ex5_Sistema_Pontuacao_Jogos.interfaces.Rankeavel;

import java.util.UUID;

public class Jogador implements Rankeavel, Notificavel{
    private UUID id;
    private String nome;
    private Integer pontuacao;
    private Integer nivel;

    public Jogador(String nome, Integer pontuacao, Integer nivel) {
        if (pontuacao < 0) {
            throw new PontuacaoInvalidaException("Pontuação Inválida!");
        }
        if (nivel < 1) {
            throw new NivelInvalido("Nível não pode ser menor que 0!");
        }

        this.id = UUID.randomUUID();
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.nivel = nivel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void ganharPontos(Integer pontos) {
        this.pontuacao += pontos;
    }

    public void subirNivel() {
        this.nivel++;
    }

    @Override
    public String obterRank() {
        if (pontuacao <= 999) {
            return "Bronze";
        } else if (pontuacao >= 1000 && pontuacao <= 1999) {
            return "Prata";
        } else if (pontuacao >= 2000 && pontuacao <= 4999) {
            return "Ouro";
        } else {
            return "Platina";
        }
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public String toString() {
        return nome + " - " + obterRank() + " - " + pontuacao + " pts";
    }
}
