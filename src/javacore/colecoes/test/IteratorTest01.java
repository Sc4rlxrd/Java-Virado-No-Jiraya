package javacore.colecoes.test;

import javacore.colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"Hellsing Ultimate",19.9,5));
        mangas.add(new Manga(1L,"Berserk",11.5,0));
        mangas.add(new Manga(4L,"Attack on titan",20.0,0));
        mangas.add(new Manga(3L,"Blue Lock",10.55,0));
        mangas.add(new Manga(2L,"Hunter X Hunter",9.99,0));
        mangas.add(new Manga(6L,"Fire Force",9.99,0));
        mangas.add(new Manga(7L,"Naruto",22.0,2));

        // permite percorrer os elementos de uma lista e remover da melhor forma possivel sem lancar exception.
        Iterator<Manga> mangaIterator = mangas.iterator();
//        while (mangaIterator.hasNext()){
//            if (mangaIterator.next().getQuntidade() ==0){
//                mangaIterator.remove();
//            }
//        }

        // agora usando a programação funcional
        mangas.removeIf(manga -> manga.getQuantidade() == 0);

        System.out.println(mangas);
    }
}
