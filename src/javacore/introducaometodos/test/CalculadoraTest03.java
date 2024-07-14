package javacore.introducaometodos.test;

import javacore.introducaometodos.dominio.Calculadora;

public class CalculadoraTest03 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.divideDoisNumeros(20,0);
        System.out.println("variavel result"+result);
        System.out.println(calculadora.divideDoisNumeros2(20,0));
        System.out.println("-------------------------------------");
        calculadora.imprimeDivisaoDeDoisNumeros(86,0);

    }
}
