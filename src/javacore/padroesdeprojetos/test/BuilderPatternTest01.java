package javacore.padroesdeprojetos.test;

import javacore.padroesdeprojetos.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Person build = new Person.PersonBuilder()
                .firstName("Guilherme")
                .lastName("Santos")
                .username("Sc4rlxrd")
                .email("Batatinha123@gmail.com")
                .build();
        System.out.println(build);
    }
}
