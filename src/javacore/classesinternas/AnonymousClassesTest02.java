package javacore.classesinternas;

import javacore.colecoes.dominio.Manga;
import javacore.generics.dominio.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        List<Barco> barcoList = new ArrayList<>(List.of(new Barco("Lancha Tubarão"), new Barco("Canoa Plástico")));
        List<Manga> mangas = new ArrayList<>(List.of(new Manga(1L,"Blue Lock",19.00), new Manga(2L,"Hunter X Hunter",9.99), new Manga(5L,"Attack on titan",19.9)));
        System.out.println("Sem Sort barco: "+ barcoList);

        // usando classe anônima para criar uma comparator para class barco local

        barcoList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        System.out.println("------------");
        System.out.println("Com Sort barco: "+barcoList);
        System.out.println("------------------------");
        System.out.println("Manga sem sort: "+mangas);
        System.out.println("------------------------");
        mangas.sort(new Comparator<Manga>() {
            @Override
            public int compare(Manga o1, Manga o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        System.out.println("Manga com sort: "+mangas);
    }
}
