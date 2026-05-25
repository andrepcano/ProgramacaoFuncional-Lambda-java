package Exercicios.Ex2;

import Exercicios.Ex2.entities.Employee;
import Exercicios.Ex2.model.services.EmployeeService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the full path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.println("Enter salary: ");
            double salary = sc.nextDouble();

            // pegando os emails na qual tem um salario maior que (salary)
            List<String> salarios = list.stream()
                    .filter(emp -> emp.getSalary() > salary)
                    .map(emp -> emp.getEmail())
                    .collect(Collectors.toList());

            salarios.forEach(System.out::println);


            // soma dos salarios quando começa com a letra 'M'
            EmployeeService empServ = new EmployeeService();

            double sum = empServ.filteredSum(list, emp -> emp.getName().charAt(0) == 'M');
            System.out.println("Sum = " + String.format("%.2f", sum));

        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }



            sc.close();
        }
    }
