package javacore.generics.service;

import javacore.generics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha Azul"), new Barco("Canoa Madeira")));

    public Barco buscarBarcoDisponivel(){
        System.out.println("Buscando barcos disponível");
        Barco barco = barcosDisponiveis.removeFirst();
        System.out.println(STR."Alugando barcos: \{barco}");
        System.out.println("Barcos disponível para alugar");
        System.out.println(barcosDisponiveis);
        return barco;
    }

    public void retornarBarcoAlugado(Barco barco){
        System.out.println(STR."Devolvendo barco: \{barco}");
        barcosDisponiveis.add(barco);
        System.out.println("Barcos disponíveis para alugar: ");
        System.out.println(barcosDisponiveis);
    }
}
