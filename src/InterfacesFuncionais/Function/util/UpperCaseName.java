package InterfacesFuncionais.Function.util;

import InterfacesFuncionais.Function.entities.Product5;

import java.util.function.Function;

public class UpperCaseName implements Function<Product5, String> {
    public String apply(Product5 p) {
        return p.getName().toUpperCase();
    }
}
