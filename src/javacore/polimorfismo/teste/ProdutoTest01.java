package javacore.polimorfismo.teste;

import javacore.polimorfismo.dominio.Computador;
import javacore.polimorfismo.dominio.Tomate;
import javacore.polimorfismo.servico.CalculadoraImposto;

public class ProdutoTest01 {
    public static void main(String[] args) {
        Computador computador = new Computador("NUC10i7",11000);
        Tomate tomate = new Tomate("Tomate Siciliano", 10);
        CalculadoraImposto.calcularImpostoComputador(computador);
        System.out.println("=========================");
        CalculadoraImposto.calcularImpostoTomate(tomate);

    }
}
