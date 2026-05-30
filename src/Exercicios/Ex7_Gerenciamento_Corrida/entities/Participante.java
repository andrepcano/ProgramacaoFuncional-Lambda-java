package Exercicios.Ex7_Gerenciamento_Corrida.entities;

public class Participante implements Comparable<Participante> {
    private String nome;
    private String país;
    private Integer tempoMedioKM;
    private Integer corridasCompletas;

    public Participante(String nome, String país, Integer tempoMedioKM, Integer corridasCompletas) {
        this.nome = nome;
        this.país = país;
        this.tempoMedioKM = tempoMedioKM;
        this.corridasCompletas = corridasCompletas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public Integer getTempoMedioKM() {
        return tempoMedioKM;
    }

    public void setTempoMedioKM(Integer tempoMedioKM) {
        this.tempoMedioKM = tempoMedioKM;
    }

    public Integer getCorridasCompletas() {
        return corridasCompletas;
    }

    public void setCorridasCompletas(Integer corridasCompletas) {
        this.corridasCompletas = corridasCompletas;
    }

    @Override
    public String toString() {
        return nome + " - " + país + " - Tempo Médio por KM: " + tempoMedioKM + " - Corridas Completas: " + corridasCompletas;
    }

    @Override
    public int compareTo(Participante outro) {
        return Integer.compare(
                this.getCorridasCompletas(),
                outro.getCorridasCompletas()
        );
    }
}
