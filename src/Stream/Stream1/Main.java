package Stream.Stream1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        // criando Stream a partir da lista
        Stream<Integer> st1 = list.stream().map(x -> x * 10); // multiplicando por 10
        System.out.println(Arrays.toString(st1.toArray())); // (toArray) converte a stream() para um array

        // craindo Stream usando (Stream.off)
        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        // usando iteracao
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2); // o "0" é o PRIMEIRO da lista
        System.out.println(Arrays.toString(st3.limit(10).toArray())); // vai ate 10 elementos

        // sequencia de fibonacci
        Stream<Long> st4 = Stream.iterate(new long[]{ 0L, 1L }, p->new long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));
    }
}
