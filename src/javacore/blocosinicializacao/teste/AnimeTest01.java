package javacore.blocosinicializacao.teste;

import javacore.blocosinicializacao.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("One Piece");
        System.out.println(anime.getNome() + ": ");
        for( int ep: anime.getEpisodios()){
            System.out.print(ep + " ");
        }
    }
}
