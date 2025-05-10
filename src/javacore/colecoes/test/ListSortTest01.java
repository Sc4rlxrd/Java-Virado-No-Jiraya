package javacore.colecoes.test;

import javacore.colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Hellsing Ultimate");
        mangas.add("Berserk");
        mangas.add("Attack on titan");
        mangas.add("Blue Lock");
        mangas.add("Hunter X Hunter");

        Collections.sort(mangas);

        System.out.println("--------------------------Mangas---------------------------");
        for (String manga:mangas){
            System.out.println(STR."MANGAS: \{manga}");
        }

        List<Double> money = new ArrayList<>(6);
        money.add(100.21);
        money.add(400.21);
        money.add(300.21);
        money.add(200.21);
        money.add(500.21);
        Collections.sort(money);
        System.out.println("--------------------------Money---------------------------");
        for (Double moneyOrdering: money){
            System.out.println(STR."Money: \{moneyOrdering}");
        }

        new Manga(null,null,0.0);
    }
}
