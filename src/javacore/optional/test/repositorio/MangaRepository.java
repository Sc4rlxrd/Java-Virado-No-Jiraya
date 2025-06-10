package javacore.optional.test.repositorio;

import javacore.optional.test.dominio.Manga;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static List<Manga> mangas = new ArrayList<>( List.of(new Manga(1,"Boku no Hero",25), new Manga(2,"Blue Lock",15)));
    private static Optional<Manga> findBy(Predicate<Manga>predicate){
        Manga found = null;
        for (Manga manga:mangas){
            if(predicate.test(manga)){
                found=manga;
            }
        }
        return Optional.ofNullable(found);
    }

    public static Optional<Manga> findByTitle(String title){
        return  findBy(m->m.getTitle().equals(title));
    }
    public static Optional<Manga> findById(Integer id){
        return  findBy(m->m.getId().equals(id));
    }
}
