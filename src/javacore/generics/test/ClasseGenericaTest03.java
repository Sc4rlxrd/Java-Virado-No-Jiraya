package javacore.generics.test;

import javacore.generics.dominio.Barco;
import javacore.generics.dominio.Carro;
import javacore.generics.service.BarcoRentavelService;
import javacore.generics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha Azul"), new Barco("Canoa Madeira")));
        RentalService<Carro> rentalService = new RentalService<>(carrosDisponiveis);
        RentalService<Barco> barcoRentalService = new RentalService<>(barcosDisponiveis);
        Carro carro = rentalService.buscarVeiculoDisponivel();
        System.out.println("Usando por um mês");
        rentalService.retornarVeiculoAlugado(carro);
        System.out.println("-----------------------------");
        Barco barco = barcoRentalService.buscarVeiculoDisponivel();
        System.out.println("Usando 7 dias");
        barcoRentalService.retornarVeiculoAlugado(barco);


    }
}
