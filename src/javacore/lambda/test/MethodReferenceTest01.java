package javacore.lambda.test;

import javacore.lambda.test.dominio.Anime;
import javacore.lambda.test.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Reference to a static method
public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Attack on titan",25), new Anime("Berserk",45),new Anime("One piece",1131), new Anime("Naruto",200), new Anime("Fire Force",4)));

        // usando lambda "pura"

         Collections.sort(animeList,(a1,a2)->a1.getTitle().compareTo(a2.getTitle()));
         Collections.sort(animeList, (a1,a2)-> a1.getEpisodes().compareTo(a2.getEpisodes()));

        // usando method reference que seria dois pontos seguidos
        Collections.sort(animeList, AnimeComparators::compareByTitle);
        Collections.sort(animeList, AnimeComparators::compareByEpisodes);
        System.out.println(animeList);
    }
}
