package javacore.streams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {
    public static void main(String[] args) {
        // o flatMap é recomendado quando for acessar dados numa lista aninhada/ uma lista dentro outra lista

        List<List<String>> devDojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Rodinei Silva","Catarina Gomes","Sandy Carolina");
        List<String> developers = List.of("Guilherme","David","Willian");
        List<String> students = List.of("Guilherme Santos","Maria Eduarda","Ana Carolina");
        devDojo.add(graphicDesigners);
        devDojo.add(developers);
        devDojo.add(students);

        // method without stream
        for (List<String> people : devDojo) {
            for (String person : people) {
                System.out.println(person);
            }

        }

        System.out.println("-------------------");
        // using default map without flatmap
        devDojo.stream().map(Collection::stream).forEach(System.out::println);
        System.out.println("-------------------");
        // using flatMap instead of map
        devDojo.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
