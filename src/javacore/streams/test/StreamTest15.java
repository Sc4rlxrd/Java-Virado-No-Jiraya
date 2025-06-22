package javacore.streams.test;

import javacore.streams.dominio.Category;
import javacore.streams.dominio.LightNovel;
import javacore.streams.dominio.Promotion;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest15 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Hellsing Ultimate",5.0, Category.TERROR),
            new LightNovel("Attack on titan",3.0,Category.TERROR),
            new LightNovel("Blue Lock",1.99,Category.SOCCER),
            new LightNovel("Naruto",2.99,Category.ACTION),
            new LightNovel("One Piece",3.99,Category.FANTASY),
            new LightNovel("Baki",8.99,Category.ACTION),
            new LightNovel("Fire Force",1.99,Category.FANTASY)));
    public static void main(String[] args) {
        // está trazendo um resumo de cada categoria de anime como a soma a média etc
        Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect);
        System.out.println("---------------------------------------");
        // ele trazer as lightNovels com promoção e o nome ordenado por gênero
        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE)));
        System.out.println(collect1);
        System.out.println("---------------------------------------");
        // ele retorna qual categoria tem promoção
        Map<Category, List<Promotion>> collect2 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toList())));
        System.out.println(collect2);

    }

    private static Promotion getPromotion(LightNovel lightNovel){
        return lightNovel.getPrice()<6? Promotion.UNDER_PROMOTION:Promotion.NORMAL_PRICE;
    }
}
