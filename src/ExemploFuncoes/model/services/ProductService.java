package ExemploFuncoes.model.services;

import ExemploFuncoes.entities.Product6;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSum(List<Product6> list, Predicate<Product6> criteria) {
        double sum = 0.0;
        for (Product6 p : list) {
            if (criteria.test(p)) {
                sum += p.getPrice();
            }
        }
        return sum;
    }
}
