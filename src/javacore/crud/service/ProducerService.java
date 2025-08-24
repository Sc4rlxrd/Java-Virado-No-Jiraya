package javacore.crud.service;

import javacore.crud.dominio.Producer;
import javacore.crud.repository.ProducerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProducerService {

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
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i <producers.size() ; i++) {
            System.out.printf("[%d] | id: %d -> %s%n", i,producers.get(i).getId() ,producers.get(i).getName());
        }
    }

    private static  void delete(){
        System.out.println("Type the id of the producer you want to delete");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Are you sure? S/N");
        String choice = scanner.nextLine();
        if("s".equalsIgnoreCase(choice)){
            ProducerRepository.delete(id);
        }
    }
    public static void save(){
        System.out.println("Type the name of the producer");
        var name = scanner.nextLine();
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }
    public static void update(){
        System.out.println("Type the id of the object you want to update");
        Optional<Producer> producerOptional = ProducerRepository.findById(Integer.parseInt(scanner.nextLine()));
        if (producerOptional.isEmpty()){
            System.out.println("Producer not found");
            return;
        }
        Producer producerFromDb = producerOptional.get();
        System.out.println("Producer found "  + producerFromDb.getName());
        System.out.println("Type the new name or enter to keep the same");
        String name = scanner.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;
        var producerToUpdate = Producer.builder().id(producerFromDb.getId()).name(name).build();
        ProducerRepository.update(producerToUpdate);
    }
}
