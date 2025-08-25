package javacore.junit.service;

import javacore.junit.dominio.Person;

import java.util.List;
import java.util.Objects;

public class PersonService {

    public boolean isAdult(Person person) {
//        Objects.requireNonNull(person,"Person can't be null");  trocar a exception vai quebrar o teste de nullPointer
        if (person == null){
            throw  new IllegalArgumentException();
        }
        return person.getAge()>=18;
    }
    public List<Person> filterRemovingNotAdult(List<Person> personList){
        return personList.stream().filter(this::isAdult).toList();
    }
}
