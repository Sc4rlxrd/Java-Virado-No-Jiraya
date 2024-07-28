package javacore.polimorfismo.servico;

import javacore.polimorfismo.dominio.Computador;
import javacore.polimorfismo.dominio.Tomate;

public class CalculadoraImposto {
    public static   void calcularImpostoComputador(Computador computador) {
        System.out.println("Relatório de imposto computador");
        double imposto = computador.calcularImposto();
        System.out.println("Computador: " + computador.getNome());
        System.out.println("Valor: " + computador.getValor());
        System.out.println("Imposto a ser  pago:  " + imposto);

    }
    public static void calcularImpostoTomate(Tomate tomate) {
        System.out.println("Relatório de imposto tomate");
        double imposto = tomate.calcularImposto();
        System.out.println("Tomate: " + tomate.getNome());
        System.out.println("Valor: " + tomate.getValor());
        System.out.println("Imposto a ser  pago:  " + imposto);

    }
}
