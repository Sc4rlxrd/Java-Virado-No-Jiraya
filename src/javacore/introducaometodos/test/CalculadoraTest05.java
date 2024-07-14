package javacore.introducaometodos.test;

import javacore.introducaometodos.dominio.Calculadora;

public class CalculadoraTest05 {
    public static void main(String[] args) {
        Calculadora calculadora  = new Calculadora();
        int [] numeros = {1,2,3,4,5};
        calculadora.somaArray(numeros);


        System.out.println("\nOpção dois....");
        calculadora.somaArray(new int[]{10,20});


        System.out.println("Usando o VarArgs...");
        calculadora.somarVarArgs(50,50,50);
        // a vantagem de usar o varArgs é que nao preciso passar o array como os jeitos acima mas se quiser pode passar

    }
}
