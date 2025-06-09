package javacore.lambda.test;

import javacore.lambda.test.dominio.Anime;
import javacore.lambda.test.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import java.util.function.Supplier;

// Reference to a constructor

public class MethodReferenceTest04 {
    public static void main(String[] args) {
        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;
        AnimeComparators animeComparators = newAnimeComparators.get();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Attack on titan",25), new Anime("Berserk",45),new Anime("One piece",1131), new Anime("Naruto",200), new Anime("Fire Force",4)));
        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);

        BiFunction<String, Integer,Anime> animeBiFunction = (title,episodes)-> new Anime(title,episodes);
        BiFunction<String, Integer,Anime> animeBiFunction2 = Anime::new;
        System.out.println(animeBiFunction2.apply("Konosuba",25));

    }
}
