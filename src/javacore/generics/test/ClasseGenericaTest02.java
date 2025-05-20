package javacore.generics.test;

import javacore.generics.dominio.Barco;
import javacore.generics.dominio.Carro;
import javacore.generics.service.BarcoRentavelService;
import javacore.generics.service.CarroRentavelService;

public class ClasseGenericaTest02 {
    public static void main(String[] args) {
        BarcoRentavelService barcoRentavelService = new BarcoRentavelService();
        Barco barco = barcoRentavelService.buscarBarcoDisponivel();
        System.out.println("Usando por uma semana....");
        barcoRentavelService.retornarBarcoAlugado(barco);
        
    }
}
