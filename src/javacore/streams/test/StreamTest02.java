package javacore.streams.test;


import javacore.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest02 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("OverLord",8.99),
            new LightNovel("Hellsing Ultimate",5.0),
            new LightNovel("Attack on titan",3.00),
            new LightNovel("Blue Lock",1.99),
            new LightNovel("Naruto",2.99),
            new LightNovel("One Piece",3.99),
            new LightNovel("Fire Force",1.99)
    ));
    public static void main(String[] args) {

        // method after api stream
        List<String> titles = lightNovels.stream().sorted(Comparator.comparing(LightNovel::getTitle)).filter(lightNovel -> lightNovel.getPrice() <= 4).limit(3).map(LightNovel::getTitle).toList();
        System.out.println(titles);
    }
}
