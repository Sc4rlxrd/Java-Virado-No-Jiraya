package javacore.colecoes.test;

import javacore.colecoes.dominio.Manga;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;


class MangaPrecoComparator implements Comparator<Manga>{
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

public class NavigableSetTes01 {
    public static void main(String[] args) {
        // Para usar o treeSet e todas as ‘interface’ de collects com tree no nome precisa está implementado o compareTo ou comparator para funcionar.
        // No caso da classe manga o compareTo esta return o ‘id’ de cada valor.
        // Toda a vez que add um novo valor o treeSet vai organizar lista novamente para poder add.
        // obs: ele não add  valores repetidos
        // obs: ele não usar o equals para comparar ele usar a ‘interface’ compareTo da classe
        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L,"Hellsing Ultimate",19.9));
        mangas.add(new Manga(1L,"Berserk",11.5));
        mangas.add(new Manga(4L,"Attack on titan",20.0));
        mangas.add(new Manga(3L,"Blue Lock",10.55));
        mangas.add(new Manga(2L,"Hunter X Hunter",9.99));
        mangas.add(new Manga(6L,"Fire Force",9.99));
        mangas.add(new Manga(7L,"Naruto",22.0));
        System.out.println("-------------------Ordem normal----------------");
        for (Manga manga:mangas){
            System.out.println(manga);
        }
        System.out.println("-------------------Z até A----------------");
        // do Z-A
        for (Manga manga:mangas.descendingSet()){
            System.out.println(manga);
        }
        // alguns métodos
        // lower <
        // floor <=
        // higher >
        // ceiling >=
        System.out.println("--------------------");
        Manga yuyu = new Manga(8L,"Yuyu Hakusho",8,5);
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));
        // alguns métodos
        // .pollFirst : remove o primeiro elemento e output ele
        // .pollLast : remove o ultimo elemento e output ele

    }
}
