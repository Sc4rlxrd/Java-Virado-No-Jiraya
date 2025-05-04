package javacore.colecoes.test;

import javacore.colecoes.dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1","Iphone");
        Smartphone s2 = new Smartphone("1ABC1","Pixel 8XL"); // retorna false porque está apontando para obj diferente
       // Smartphone s2 = s1; // está apontando para o mesmo obj
        System.out.println(s1.equals(s2));
    }
}
