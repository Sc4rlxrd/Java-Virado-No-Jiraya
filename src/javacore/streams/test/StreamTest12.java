package javacore.streams.test;

import javacore.streams.dominio.Category;
import javacore.streams.dominio.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest12 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Hellsing Ultimate",5.0, Category.TERROR),
            new LightNovel("Attack on titan",3.0,Category.TERROR),
            new LightNovel("Blue Lock",1.99,Category.SOCCER),
            new LightNovel("Naruto",2.99,Category.ACTION),
            new LightNovel("One Piece",3.99,Category.FANTASY),
            new LightNovel("Baki",8.99,Category.ACTION),
            new LightNovel("Fire Force",1.99,Category.FANTASY)));
    public static void main(String[] args) {

        // METODO ANTIGO SEM STREAM
        Map<Category,List<LightNovel>> categoryLightNovelMap = new HashMap<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> terror = new ArrayList<>();
        List<LightNovel> soccer = new ArrayList<>();
        List<LightNovel> action = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()){
                case ACTION -> {
                    action.add(lightNovel);
                    break;
                }
                case SOCCER -> {
                    soccer.add(lightNovel);
                    break;
                }
                case TERROR -> {
                    terror.add(lightNovel);
                    break;
                }
                case FANTASY -> {
                    fantasy.add(lightNovel);
                    break;
                }
            }

        }
        categoryLightNovelMap.put(Category.ACTION,action);
        categoryLightNovelMap.put(Category.SOCCER,soccer);
        categoryLightNovelMap.put(Category.TERROR,terror);
        categoryLightNovelMap.put(Category.FANTASY,fantasy);
        System.out.println(categoryLightNovelMap);
        System.out.println("---------------------------------");
        // METODO USANDO STREAM
        Map<Category, List<LightNovel>> categoryLightNovelStream = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(categoryLightNovelStream);

    }
}
