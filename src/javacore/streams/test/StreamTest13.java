package javacore.streams.test;

import javacore.streams.dominio.Category;
import javacore.streams.dominio.LightNovel;
import javacore.streams.dominio.Promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Hellsing Ultimate",5.0, Category.TERROR),
            new LightNovel("Attack on titan",3.0,Category.TERROR),
            new LightNovel("Blue Lock",1.99,Category.SOCCER),
            new LightNovel("Naruto",2.99,Category.ACTION),
            new LightNovel("One Piece",3.99,Category.FANTASY),
            new LightNovel("Baki",8.99,Category.ACTION),
            new LightNovel("Fire Force",1.99,Category.FANTASY)));
    public static void main(String[] args) {
        Map<Promotion, List<LightNovel>> promotionLightNovel = lightNovels.stream().collect(Collectors.groupingBy(lightNovel -> lightNovel.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE));
        System.out.println(promotionLightNovel);
        Map<Category, Map<Promotion, List<LightNovel>>> categoryAndPromotion = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE)));
        System.out.println("---------------------------------------");
        System.out.println(categoryAndPromotion);

    }
}
