package Exercicios.Ex2.model.services;

import Exercicios.Ex2.entities.Employee;

import java.util.List;
import java.util.function.Predicate;

public class EmployeeService {

    public double filteredSum(List<Employee> list, Predicate<Employee> criteria) {
        double sum = 0.0;
       for (Employee emp : list) {
           if (criteria.test(emp)) {
               sum += emp.getSalary();
           }
       }
       return sum;
    }
}
