package javacore.streams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        // seed valor inicial depois um lambda com a lógica de continuação
        Stream.iterate(1,n-> n+1).limit(10).forEach(System.out::print);

        System.out.println();

        Stream.iterate(new int[]{0,1}, n-> new int[]{n[1], n[0]+n[1]}).limit(10).forEach(a-> System.out.println(Arrays.toString(a)));

        // mini  sequência de Fibonacci
        Stream.iterate(new int[]{0,1}, n-> new int[]{n[1], n[0]+n[1]}).limit(10).map(a->a[0]).forEach(System.out::println);

        System.out.println("--------------------------");
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(()->random.nextInt(1,50)).limit(25).forEach(n-> System.out.print(n+ " |"));


    }
}
