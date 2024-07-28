package javacore.polimorfismo.teste;

import javacore.polimorfismo.dominio.Computador;
import javacore.polimorfismo.dominio.Produto;
import javacore.polimorfismo.dominio.Tomate;
import javacore.polimorfismo.servico.CalculadoraImposto;

public class ProdutoTest03 {
    public static void main(String[] args) {
        Produto produto = new Computador("Ryzen 9", 3000);
        Tomate tomate = new Tomate("Americano", 20);
       tomate.setDataDeValidade("29/07/2024");
        CalculadoraImposto.calcularImposto(tomate);
        System.out.println("=============================");
        CalculadoraImposto.calcularImposto(produto);


    }
}
