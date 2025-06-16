package javacore.streams.test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {

    // GERANDO STREAMS SEM ESTÁ NUMA LISTA

    public static void main(String[] args) {
        // rangeClosed vai incluir o valor inicial e o final na stream
        IntStream.rangeClosed(1,50).filter(n->n%2==0).forEach(n-> System.out.print(n +" "));
        System.out.println();
        // range vai ignorar o ultimo valor dado
        IntStream.range(1,50).filter(n->n%2==0).forEach(n-> System.out.print(n +" "));
        System.out.println();

        // 1 forma de criar stream sem lista
        Stream.of("Eleve ", "O ","Cosmo ","no seu coração").map(String::toUpperCase).forEach(s-> System.out.print(s +" "));
        System.out.println();
        Stream.of("Eleve ", "O ","Cosmo ","no seu coração").map(String::toLowerCase).forEach(s-> System.out.print(s +" "));
        System.out.println();

        int num[] = {1,2,3,4,5,};
        Arrays.stream(num).forEach(n-> System.out.print(n+" "));
        System.out.println();
        Arrays.stream(num).average().ifPresent(n-> System.out.print(n+" "));
        System.out.println();

        // trabalhando com arquivos txt, etc.

        try(Stream<String> lines = Files.lines(Paths.get("file.txt")) ) {
            lines.filter(s->s.contains("Manjaro")).forEach(System.out::println);
            lines.filter(s->s.contains("Java")).forEach(System.out::println);
            lines.filter(s->s.contains("openjdk-21")).forEach(System.out::println);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
