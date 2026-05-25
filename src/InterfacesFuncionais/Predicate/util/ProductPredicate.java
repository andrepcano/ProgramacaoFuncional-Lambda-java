package InterfacesFuncionais.Predicate.util;

import InterfacesFuncionais.Predicate.entities.Product3;

import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product3> {
    @Override
    public boolean test(Product3 p) {
        return p.getPrice() >= 100.0;
    }
}
