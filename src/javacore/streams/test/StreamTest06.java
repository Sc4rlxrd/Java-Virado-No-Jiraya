package javacore.streams.test;

import javacore.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Hellsing Ultimate",5.0),
            new LightNovel("Attack on titan",3.0),
            new LightNovel("Blue Lock",1.99),
            new LightNovel("Naruto",2.99),
            new LightNovel("One Piece",3.99),
            new LightNovel("Baki",8.99),
            new LightNovel("Fire Force",1.99)));
    public static void main(String[] args) {
        /*
              anyMatch: any one meets the filter condition
              allMatch: all match the filter condition
              noneMatch: if none match the filter condition
         */

        System.out.println("AnyMatch: "+lightNovels.stream().anyMatch(ln -> ln.getPrice() >= 3));
        System.out.println("AllMatch: "+ lightNovels.stream().allMatch(lightNovel -> lightNovel.getPrice() > 0));
        System.out.println("NoneMatch: "+lightNovels.stream().noneMatch(lightNovel -> lightNovel.getPrice() < 0));
        // findAny returns any element from the stream
        lightNovels.stream().filter(lightNovel -> lightNovel.getPrice()<3).findAny().ifPresent(System.out::println);
        // findFirst returns the first element of the stream
        lightNovels.stream().filter(lightNovel -> lightNovel.getPrice()>3).sorted(Comparator.comparing(LightNovel::getPrice).reversed()).findFirst().ifPresent(System.out::println);
        // using .max which would "kill" the .sorted from the stream above.
        lightNovels.stream().filter(lightNovel -> lightNovel.getPrice() > 3).max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);


    }
}
