package javacore.sobrecargametodos.teste;

import javacore.sobrecargametodos.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime();
        anime.init("Jujutsu kaisen","Tv",23,"Ação");

        anime.imprime();
    }
}
