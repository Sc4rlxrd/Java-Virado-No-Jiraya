package javacore.streams.test;

import javacore.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
    private  static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Hellsing Ultimate",5.0),
            new LightNovel("Attack on titan",3.0),
            new LightNovel("Blue Lock",1.99),
            new LightNovel("Naruto",2.99),
            new LightNovel("One Piece",3.99),
            new LightNovel("Baki",8.99),
            new LightNovel("Fire Force",1.99)));
    public static void main(String[] args) {
        // esse metodo funciona mais o java transforma o tipo primitivo da class em warp e vice-versa podendo perder um pouco do desempenho
        lightNovels.stream().map(LightNovel::getPrice).filter(price -> price>=3).reduce(Double::sum).ifPresent(System.out::println);
        // dessa forma ele não faz mais o warp de tipo.
        double sum = lightNovels.stream().mapToDouble(LightNovel::getPrice).filter(price -> price >= 3).sum();
        System.out.println(sum);

    }
}
