package javacore.generics.test;

import javacore.colecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        // type erasure → age em tempo de compilação de código
        List list = new ArrayList<>();  // aqui ele é tipo obj recebe qualquer valor, mas quando for percorrer/ manipular a lista pode ocorrer a lançar uma exception
        list.add("Midoriya");
        list.add(123);
        list.add("Sky");
        for (Object o : list){
            System.out.println("Sem generics: "+o);
        }
        System.out.println("---------");
        List<String> list1 = new ArrayList<>(); // agora usando generics
        list1.add("Midoriya");
        list1.add("Midoriya");
        for(String o: list1){
            System.out.println("Com generics: " + o);
        }
        System.out.println("-----------------");
        add(list1,new Consumidor("Bakugo"));

//        for(String o: list1){   lança exception devido ao tipo da lista o correto é colocar no for Obj
//            System.out.println("Com generics: " + o);
//        }

        for (Object o : list1){
            System.out.println("obj como generics: " + o);
        }

    }
    private static void  add(List list, Consumidor consumidor){
        list.add(consumidor);
    }
}
