package test;

import javacore.junit.dominio.Person;
import javacore.junit.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class PersonServiceTest {
    // o assert espera dois parâmetro um deles e o resultado esperado e outro é o objeto ou a lógica a ser testado no exemplo abaixo, eu espero que o resultado do teste seja false e a lógica e o personService.isAdult
    // caso o teste retorne true ele não passa
    // A anotação @DisplayName permite definir um nome personalizado e mais descritivo para classes e métodos de teste
    // A anotação @BeforeEach é para executar um mét0do antes de todos os casos de teste numa classe. Essas anotações servem para inicializar objetos, preparar pré-condições e configurar o estado da aplicação antes da execução dos testes, reduzindo a repetição de código.
    // estou usando para criar um objc específico para os dois testes.
    // é uma mini convenção criar um metodo setUp de instanciar os objc

    private Person adult;
    private Person notAdult;
    private PersonService personService;
    @BeforeEach
    public void setUp(){
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
    }
    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Assertions.assertFalse(personService.isAdult(notAdult));
    }
    @Test
    @DisplayName("A person should be not adult when age is greater or equals than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualsThan18() {
        Assertions.assertFalse(personService.isAdult(adult));
    }
    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void isAdult_ShouldThrowException_WhenPersonIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> personService.isAdult(null));
    }
    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed(){
        // crie aqui por praticidade, mas poderia criar no setUp
        Person person1 = new Person(17); // menor
        Person person2 = new Person(18); // maior
        Person person3 = new Person(21); // maior
        List<Person> personList = List.of(person1, person2, person3);
        //  Esse 2 seria o parâmetro que espero que retornar da lista após passar pelo filter que só poderia ter dois valores. No meu caso, tem 3 pessoas, mas somente 2 são adultas.
        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size());
    }

}