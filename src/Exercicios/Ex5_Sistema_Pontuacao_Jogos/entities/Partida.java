package Exercicios.Ex5_Sistema_Pontuacao_Jogos.entities;

public class Partida {

    private Jogador vencedor;
    private Jogador perdedor;
    private Integer pontosGanhos;

    public Partida(Jogador vencedor, Jogador perdedor, Integer pontosGanhos) {
        this.vencedor = vencedor;
        this.perdedor = perdedor;
        this.pontosGanhos = pontosGanhos;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public Jogador getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(Jogador perdedor) {
        this.perdedor = perdedor;
    }

    public Integer getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(Integer pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public void finalizarPartida() {
        vencedor.ganharPontos(pontosGanhos);
        if (vencedor.getPontuacao() >= 2000) {
            vencedor.subirNivel();
        }
    }
}
