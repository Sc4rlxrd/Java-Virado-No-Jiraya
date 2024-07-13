package javacore.introducaoclasses.test;

import javacore.introducaoclasses.dominio.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.nome = "uno";
        carro.modelo = "Fire";
        carro.ano= 1995;

        Carro carro2 = new Carro();
        carro2.nome ="Mustang ";
        carro2.modelo ="Gt edition";
        carro2.ano =2024;

        // referencia de objeto de memoria  carro vai ter os mesmos dados do carro2, mas funciona somente com obj do mesmo tipo carro
        //carro = carro2;

        System.out.println("--------------------------------------");

        System.out.println("Carro 1 ");
        System.out.println("nome:" + carro.nome + ", modelo: " + carro.modelo  + ", ano: " + carro.ano);
        System.out.println("--------------------------------------");

        System.out.println("Carro 2 ");
        System.out.println("nome:" + carro2.nome + ", modelo: " + carro2.modelo  + ", ano: " + carro2.ano);

        System.out.println("--------------------------------------");


    }
}
