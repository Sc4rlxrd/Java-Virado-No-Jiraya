package javacore.colecoes.test;

import javacore.colecoes.dominio.Consumidor;
import javacore.colecoes.dominio.Manga;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Guilherme");
        Consumidor consumidor2 = new Consumidor("Scarlxrd");
        Manga manga1 = new Manga(5L, "Hellsing Ultimate", 19.9);
        Manga manga2 = new Manga(1L, "Berserk", 11.5);
        Manga manga3 = new Manga(4L, "Attack on titan", 20.0);
        Manga manga4 = new Manga(3L, "Blue Lock", 10.55);
        Map<Consumidor,Manga> consumidorManga = new LinkedHashMap<>();
        consumidorManga.put(consumidor1,manga1);
        // consumidorManga.put(consumidor1,manga2); // sobrescreve o valores  do consumidor1
        consumidorManga.put(consumidor2, manga4);
        for(Map.Entry<Consumidor,Manga> entry : consumidorManga.entrySet()){
            System.out.println("Consumidor: " + entry.getKey().getNome() + " - mangá: " + entry.getValue().getNome());
        }
    }
}
