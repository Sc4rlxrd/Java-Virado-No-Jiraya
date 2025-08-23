package javacore.crud.service;

import javacore.crud.dominio.Producer;
import javacore.crud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class ProducerService {

    private static Scanner scanner = new Scanner(System.in);
    public static void buildMenu(int op){
        switch (op){
            case 1: findbyName(); break;
            default: throw  new IllegalArgumentException("Not a valid option");
        }
    }
    private static void findbyName(){
        System.out.println("Type the name of empty to all ");
        String name = scanner.nextLine();
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i <producers.size() ; i++) {
            System.out.printf("[%d] - %s%n", i, producers.get(i).getName());
        }
    }
}
