package test;

import javacore.junit.dominio.Person;
import javacore.junit.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PersonServiceTest {
    // o assert espera dois parâmetro um deles e o resultado esperado e outro é o objeto ou a lógica a ser testado no exemplo abaixo, eu espero que o resultado do teste seja false e a lógica e o personService.isAdult
    // caso o teste retorne true ele não passa
    // A anotação @DisplayName permite definir um nome personalizado e mais descritivo para classes e métodos de teste
    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Person person = new Person(15);
        PersonService personService = new PersonService();
        Assertions.assertFalse(personService.isAdult(person));
    }
}