package javacore.crud.service;

import javacore.crud.dominio.Anime;
import javacore.crud.dominio.Producer;
import javacore.crud.repository.AnimeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AnimeService {

    private static final Scanner scanner = new Scanner(System.in);
    public static void buildMenu(int op){
        switch (op){
            case 1: findByName(); break;
            case 2: delete(); break;
            case 3: save(); break;
            case 4: update(); break;
            default: throw  new IllegalArgumentException("Not a valid option");
        }
    }
    private static void findByName(){
        System.out.println("Type the name of empty to all ");
        String name = scanner.nextLine();
        AnimeRepository.findByName(name).forEach(p -> System.out.println("Id: " + p.getId() + "| Name: " + p.getName() + "| Episodes: " + p.getEpisodes() + "| Producer: "+ p.getProducer().getName()));
    }

    private static  void delete(){
        System.out.println("Type the id of the anime you want to delete");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = scanner.nextLine();
        if("y".equalsIgnoreCase(choice)){
            AnimeRepository.delete(id);
        }
    }
    public static void save(){
        System.out.println("Type the name of the anime");
        var name = scanner.nextLine();
        System.out.println("Type the number of episodes");
        var episodes = Integer.parseInt(scanner.nextLine());
        System.out.println("Type the id of the producer");
        Integer producerId = Integer.parseInt(scanner.nextLine());
        Anime anime = Anime.builder()
                .episodes(episodes)
                .name(name)
                .producer(Producer.builder().id(producerId).build())
                .build();
        AnimeRepository.save(anime);
    }
    public static void update(){
        System.out.println("Type the id of the object you want to update");
        Optional<Anime> animeOptional = AnimeRepository.findById(Integer.parseInt(scanner.nextLine()));
        if (animeOptional.isEmpty()){
            System.out.println("Anime not found");
            return;
        }
        Anime animeFromDb = animeOptional.get();
        System.out.println("Anime found "  + animeFromDb.getName());
        System.out.println("Type the new name or enter to keep the same");
        String name = scanner.nextLine();
        name = name.isEmpty() ? animeFromDb.getName() : name;
        System.out.println("Type the new number fo episodes");
        var episodes = Integer.parseInt(scanner.nextLine());
        var animeToUpdate = Anime.builder().id(animeFromDb.getId()).episodes(episodes).producer(animeFromDb.getProducer()).name(name).build();
        AnimeRepository.update(animeToUpdate);
    }
}
