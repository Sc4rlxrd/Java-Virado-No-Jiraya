package javacore.crud.test;

import javacore.crud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private  static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        while (true){
            producerMenu();
            op = Integer.parseInt(scanner.nextLine());
            if(op == 0) break;
            ProducerService.buildMenu(op);

        }
    }
    private static void producerMenu(){
        System.out.println("Type the number of your operation ");
        System.out.println("1º Search for producer ");
        System.out.println("2º Delete producer ");
        System.out.println("3º Save producer ");
        System.out.println("0º Exit");
    }
}
