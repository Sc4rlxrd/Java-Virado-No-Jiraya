package javacore.colecoes.test;

import javacore.colecoes.dominio.Manga;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new LinkedHashSet<>();
        mangas.add(new Manga(5L,"Hellsing Ultimate",19.9,5));
        mangas.add(new Manga(1L,"Berserk",11.5,0));
        mangas.add(new Manga(4L,"Attack on titan",20.0,0));
        for(Manga manga: mangas){
            System.out.println(manga);
        }
    }
}
