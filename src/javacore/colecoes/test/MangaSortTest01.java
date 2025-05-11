package javacore.colecoes.test;

import javacore.colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByNameComparator implements Comparator<Manga>{
    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getNome().compareTo(manga2.getNome());

        // uma forma de comparar sem mudar a classe principal.
    }
}
public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"Hellsing Ultimate",19.9));
        mangas.add(new Manga(1L,"Berserk",11.5));
        mangas.add(new Manga(4L,"Attack on titan",20.0));
        mangas.add(new Manga(3L,"Blue Lock",10.55));
        mangas.add(new Manga(2L,"Hunter X Hunter",9.99));
        mangas.add(new Manga(6L,"Fire Force",9.99));
        mangas.add(new Manga(7L,"Naruto",22.0));
       for (Manga manga:mangas){
           System.out.println(manga);
       }
        System.out.println("--------Ordenando....--------------");
        Collections.sort(mangas);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("--------Ordenando Por nome--------------");
        Collections.sort(mangas, new MangaByNameComparator());
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
