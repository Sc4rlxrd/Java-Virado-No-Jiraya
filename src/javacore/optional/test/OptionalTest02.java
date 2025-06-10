package javacore.optional.test;

import javacore.optional.test.dominio.Manga;
import javacore.optional.test.repositorio.MangaRepository;

import java.util.List;
import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {

        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no Hero");
        mangaByTitle.ifPresent(m->m.setTitle("Boku no Hero 2"));
        System.out.println(mangaByTitle);


        Manga mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaById);

        Manga newManga = MangaRepository.findByTitle("Dr.Stone").orElseGet(() -> new Manga(3, "Dr.Stone", 45));
        System.out.println(newManga);

    }
}
