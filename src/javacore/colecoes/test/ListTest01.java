package javacore.colecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(); //  1.5  implementado no java.
        nomes.add("Guilherme");
        nomes.add("Linux Manjaro");
        nomes.remove(1);
        nomes.add("Salve");
        nomes.add("Salve");
        nomes.add("Salve");
        System.out.println(nomes.size());

        System.out.println("Usando foreach");
        for(String nome:nomes){
            System.out.println("Nomes:  "+nome);
        }
        System.out.println("-----------------------");
        System.out.println("Usando for com índice");
        for(int i = 0; i < nomes.size(); i++) {
            System.out.println("Nomes:    " +nomes.get(i));
        }
        /*
            se precisar criar uma lista de tipo primitivo vai ter que usar os Wrappers do java
            Ex: List<Integer> numeros = new ArrayList<>(); => para lista com valores int
            Ex: List<Long> numeros = new ArrayList<>();   => para lista com valores long
            Ex: List<Char> numeros = new ArrayList<>();   => para lista com valores chars
         */
        System.out.println("-----------------------------");
        System.out.println("Lista de numeros Int");
        List<Integer> numeros1 = new ArrayList<>();
        List<Integer> numeros2 = new ArrayList<>();
        numeros1.add(11);
        numeros1.add(12);
        numeros1.add(13);
        // para add os valores da lista 2 na 1 usar o addAll()
        // as duas listas deve ser o mesmo tipo
        numeros2.add(14);
        numeros2.add(15);
        numeros2.add(16);
        numeros1.addAll(numeros2);
        for(Integer number:numeros1){
            System.out.println("Numeros Juntos: "+ number);
        }
    }
}
