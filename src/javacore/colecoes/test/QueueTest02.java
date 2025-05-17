package javacore.colecoes.test;

import javacore.colecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed());
        mangas.add(new Manga(5L,"Hellsing Ultimate",19.9));
        mangas.add(new Manga(1L,"Berserk",11.5));
        mangas.add(new Manga(4L,"Attack on titan",20.0));
        mangas.add(new Manga(3L,"Blue Lock",10.55));
        mangas.add(new Manga(2L,"Hunter X Hunter",9.99));
        mangas.add(new Manga(6L,"Fire Force",9.99));
        mangas.add(new Manga(7L,"Naruto",22.0));

        // por padrão a class manga order por id

        while (!mangas.isEmpty()){
            // out do valor + alto para sair
            System.out.println(mangas.poll());
        }
    }
}
