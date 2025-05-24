package javacore.generics.test;

import javacore.generics.dominio.Barco;

import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> canoaTubarao = criarArrayComUmObjeto(new Barco("Canoa Tubarão"));
        System.out.println(canoaTubarao);
    }
    private static <T> List<T> criarArrayComUmObjeto(T t){
        return List.of(t);
    }
}
