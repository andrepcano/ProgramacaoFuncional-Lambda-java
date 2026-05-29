package Exercicios.Ex6_Controle_Funcionarios.entities;

public class Funcionario {
    private String nome;
    private String cargo;
    private Double salario;
    private Integer anosExperiencia;

    public Funcionario(String nome, String cargo, Double salario, Integer anosExperiencia) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.anosExperiencia = anosExperiencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public Integer getAnosExperiencia() {
        return anosExperiencia;
    }

    @Override
    public String toString() {
        return nome + " - "
                + cargo + " - R$:"
                + salario + "Experiência: "
                + anosExperiencia;
    }
}
