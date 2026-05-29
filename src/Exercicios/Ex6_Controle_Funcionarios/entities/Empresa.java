package Exercicios.Ex6_Controle_Funcionarios.entities;

import java.util.ArrayList;
import java.util.List;

public class Empresa<T> {

    private List<T> funcionarios = new ArrayList<>();

    public void adicionar(T funcionario) {
        funcionarios.add(funcionario);
    }

    public List<T> listar() {
        return funcionarios;
    }
}
