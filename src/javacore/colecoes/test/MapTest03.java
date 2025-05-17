package javacore.colecoes.test;

import javacore.colecoes.dominio.Consumidor;
import javacore.colecoes.dominio.Manga;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {

        // uma forma de add vários valores num hashMap basta add os valores numa lista como no exemplo abaixo

        Consumidor consumidor1 = new Consumidor("Guilherme");
        Consumidor consumidor2 = new Consumidor("Scarlxrd");
        Manga manga1 = new Manga(5L, "Hellsing Ultimate", 19.9,3);
        Manga manga2 = new Manga(1L, "Berserk", 11.5,2);
        Manga manga3 = new Manga(4L, "Attack on titan", 20.0,1);
        Manga manga4 = new Manga(3L, "Blue Lock", 10.55,2);
        List<Manga> mangaConsumidor1List = List.of(manga1,manga2,manga3);
        List<Manga> mangaConsumidor2List = List.of(manga4,manga1);
        Map<Consumidor, List<Manga>> consumidorMangaMap = new LinkedHashMap<>();
        consumidorMangaMap.put(consumidor1,mangaConsumidor1List);
        consumidorMangaMap.put(consumidor2,mangaConsumidor2List);

        for(Map.Entry<Consumidor,List<Manga>> entry : consumidorMangaMap.entrySet()){
            System.out.println("Consumidor: " + entry.getKey().getNome());
            for (Manga manga: entry.getValue()){
                System.out.println(STR."          Mangá: \{manga.getNome()}");
                System.out.println(STR."           quantidade: \{manga.getQuantidade()}");
                System.out.println("------------------------------------------------------");
            }
        }
    }
}
