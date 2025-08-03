package javacore.padroesdeprojetos.test;

import javacore.padroesdeprojetos.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Person person = Person.PersonBuilder.aPerson().firstName("Scarlxrd").lastName("Silva").username("Scarlxrd").email("Batatinha123@gmail.com").build();
        System.out.println(person);
    }
}
