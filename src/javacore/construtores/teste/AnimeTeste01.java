package javacore.construtores.teste;

import javacore.construtores.dominio.Anime;

public class AnimeTeste01 {
    public static void main(String[] args) {
        Anime anime = new Anime("Haikyuu", "tv",12,"Ação","Production IG");
        //Anime anime1 = new Anime();
        anime.imprime();
//        anime1.imprime();
    }
}
