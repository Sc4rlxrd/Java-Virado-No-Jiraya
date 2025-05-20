package javacore.generics.service;

import javacore.generics.dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRentavelService {
    private List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca")));

    public Carro buscarCarroDisponivel(){
        System.out.println("Buscando carros disponível");
        Carro carro = carrosDisponiveis.removeFirst();
        System.out.println(STR."Alugando carro: \{carro}");
        System.out.println("Carros disponível para alugar");
        System.out.println(carrosDisponiveis);
        return carro;
    }

    public void retornarCarroAlugado(Carro carro){
        System.out.println(STR."Devolvendo carro: \{carro}");
        carrosDisponiveis.add(carro);
        System.out.println("Carros disponíveis para alugar: ");
        System.out.println(carrosDisponiveis);
    }
}
