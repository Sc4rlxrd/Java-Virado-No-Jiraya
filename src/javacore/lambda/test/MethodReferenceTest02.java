package javacore.lambda.test;

import javacore.lambda.test.dominio.Anime;
import javacore.lambda.test.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

// Reference to an instance method of a particular object
public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Attack on titan",25), new Anime("Berserk",45),new Anime("One piece",1131), new Anime("Naruto",200), new Anime("Fire Force",4)));
        // reference method
        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        // lambda pure
        animeList.sort((a1,a2)-> animeComparators.compareByEpisodesNonStatic(a1,a2));

        System.out.println(animeList);

    }
}
