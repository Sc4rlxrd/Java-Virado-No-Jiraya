package javacore.streams.test;


import javacore.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest03 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Hellsing Ultimate",5.0),
            new LightNovel("Attack on titan",3.00),
            new LightNovel("Blue Lock",1.99),
            new LightNovel("Naruto",2.99),
            new LightNovel("One Piece",3.99),
            new LightNovel("Fire Force",1.99)
    ));
    public static void main(String[] args) {
        lightNovels.stream().forEach(System.out::println); // stream tem o seu próprio foreach sem gastar tanto processo
        long count = lightNovels.stream().distinct().filter(lightNovel -> lightNovel.getPrice() <= 3).count();
        long count2= lightNovels.stream().filter(lightNovel -> lightNovel.getPrice() <= 4).count();

        System.out.println(count);
        System.out.println(count2);

    }
}
