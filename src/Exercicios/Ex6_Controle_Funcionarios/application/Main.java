package Exercicios.Ex6_Controle_Funcionarios.application;

import Exercicios.Ex6_Controle_Funcionarios.entities.Empresa;
import Exercicios.Ex6_Controle_Funcionarios.entities.Funcionario;
import Exercicios.Ex6_Controle_Funcionarios.service.FuncionariosService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Empresa<Funcionario> empresa = new Empresa<>();


        System.out.println("Quantos funcionarios quer adicionar?:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i<= n; i++) {
            System.out.println("Funcionario #" + i);
            System.out.print("Nome: ");
            String nome = sc.next();
            sc.nextLine();
            System.out.print("Cargo: ");
            String cargo = sc.next();
            sc.nextLine();
            System.out.print("Salario: ");
            double salario = sc.nextDouble();
            System.out.print("Anos de Experiência: ");
            int anosExperiencia = sc.nextInt();
            sc.nextLine();

            Funcionario funcionario = new Funcionario(nome, cargo, salario, anosExperiencia);
            empresa.adicionar(funcionario);
        }

        FuncionariosService fS = new FuncionariosService();

        System.out.println("========================\n" +
                "      FUNCIONARIOS\n" +
                "========================\n");

        empresa.listar().forEach(System.out::println);


        System.out.println("ORDENAR POR SALÁRIO:\n");
        List<Funcionario> ordenados = fS.ordenarSalario(empresa.listar());
        System.out.println(ordenados);

        System.out.print("Pessoas de qual cargo quer ver?: ");
        String cargoEspecifico = sc.next();

        System.out.println("FILTRO POR CARGO:\n");
        String cargosFiltrados = fS.filtrarCargo(empresa.listar(), cargoEspecifico);
        System.out.println(cargosFiltrados);

        System.out.println("SALÁRIO TOTAL:\n");
        Double total = fS.totalSalario(empresa.listar());
        System.out.println("R$: " + total);

        System.out.println("A partir de qual salario quer filtrar?: ");
        Double minSalario = sc.nextDouble();

        System.out.println("SALÁRIOS ACIMA DE R$" + minSalario);
        List<Funcionario> salariosFiltrados = fS.filtrarSalario(empresa.listar(), minSalario);
        System.out.println(salariosFiltrados);
     }
}
