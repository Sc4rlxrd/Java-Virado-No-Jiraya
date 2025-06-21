package javacore.streams.test;

import javacore.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Hellsing Ultimate",5.0),
            new LightNovel("Attack on titan",3.0),
            new LightNovel("Blue Lock",1.99),
            new LightNovel("Naruto",2.99),
            new LightNovel("One Piece",3.99),
            new LightNovel("Baki",8.99),
            new LightNovel("Fire Force",1.99)));
    public static void main(String[] args) {

        // o primeiro exemplo usando a stream padrão
        // o segundo exemplo usando o ‘framework’ collectors
        // no caso os dois exemplos são de contar elementos da lista
        System.out.println(lightNovels.stream().count());
        System.out.println(lightNovels.stream().collect(Collectors.counting()));

        // o valor máximo da lista pode ser o preço, etc.
        lightNovels.stream().max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);
        lightNovels.stream().collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))).ifPresent(System.out::println);

        // a soma de tod0s os valores da lista
        System.out.println(lightNovels.stream().mapToDouble(LightNovel::getPrice).sum());
        System.out.println(lightNovels.stream().collect(Collectors.summingDouble(ln-> ln.getPrice())));

        // a média da lista passando o preço
        lightNovels.stream().mapToDouble(LightNovel::getPrice).average().ifPresent(System.out::println);
        System.out.println(lightNovels.stream().collect(Collectors.averagingDouble(LightNovel::getPrice)));

        // summaryStatistics junta todas esse cont, average , max etc
        DoubleSummaryStatistics collect = lightNovels.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(collect);

        // mini exemplo pegando tod0s títulos e separando com virgula
        String titles = lightNovels.stream().map(LightNovel::getTitle).collect(Collectors.joining(", "));
        System.out.println("Titles: " + titles);


    }
}
