package Exercicios.Ex6_Controle_Funcionarios.service;

import Exercicios.Ex6_Controle_Funcionarios.entities.Empresa;
import Exercicios.Ex6_Controle_Funcionarios.entities.Funcionario;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class FuncionariosService {

    public List<Funcionario> ordenarSalario(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getSalario).reversed())
                .toList();
    }

    public String filtrarCargo(List<Funcionario> funcionarios, String cargo) {
        return funcionarios.stream()
                .filter(f -> f.getCargo().equals(cargo))
                .toList().toString();
    }

    public Double totalSalario(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .mapToDouble(f -> f.getSalario())
                .sum();
    }

    public static <T extends Comparable<? super T>> T max(List<T> funcionarios) {
        if (funcionarios.isEmpty()) {
            throw new IllegalStateException("Não pode estar vazia!");
        }
        T max = funcionarios.get(0);
        for (T item : funcionarios) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public List<Funcionario> filtrarSalario(List<Funcionario> funcionarios, Double salario) {
        return funcionarios.stream()
                .filter(f -> f.getSalario() > salario)
                .toList();
    }
}
