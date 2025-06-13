package javacore.streams.test;


import javacore.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 1. order LightNovel by title
// 2. Retrieve the first 3 title light novels with price less than 4
public class StreamTest01 {
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

        // method without api stream

        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            if (lightNovel.getPrice()<=4){
                titles.add(lightNovel.getTitle());
            }
            if (titles.size()>=3){
                break;
            }
        }
        System.out.println(lightNovels);
        System.out.println(titles);

    }
}
