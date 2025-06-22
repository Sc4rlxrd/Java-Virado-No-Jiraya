package javacore.streams.test;

import javacore.streams.dominio.Category;
import javacore.streams.dominio.LightNovel;
import javacore.streams.dominio.Promotion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest14 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Hellsing Ultimate",5.0, Category.TERROR),
            new LightNovel("Attack on titan",3.0,Category.TERROR),
            new LightNovel("Blue Lock",1.99,Category.SOCCER),
            new LightNovel("Naruto",2.99,Category.ACTION),
            new LightNovel("One Piece",3.99,Category.FANTASY),
            new LightNovel("Baki",8.99,Category.ACTION),
            new LightNovel("Fire Force",1.99,Category.FANTASY)));
    public static void main(String[] args) {
        // contando a quantidade de gêneros de animes
        Map<Category, Long> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(collect);
        System.out.println("---------------------------------------");
        // ele separa a lightNovel de maior valor de cada género da lista
        Map<Category, Optional<LightNovel>> collect1 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect1);
        System.out.println("---------------------------------------");
        // agora tirando o Optional do return do exemplo acima
        Map<Category, LightNovel> collect2 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)), Optional::get)));
        System.out.println(collect2);
        System.out.println("---------------------------------------");
        // outra forma de fazer o mesmo de cima
        Map<Category, LightNovel> collect3 = lightNovels.stream().collect(Collectors.toMap(LightNovel::getCategory, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect3);
    }
}
