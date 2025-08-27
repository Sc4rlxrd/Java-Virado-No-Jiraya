package javacore.junit.dominio;

import java.util.Objects;

// leve introdução a classe record
//  ela é final
//  não tem métodos set
public record Manga(String name , int episodes) {
    // se precisar criar um construtor para validar algum dado
    // a melhor opção seria o construtor simplificado
    public Manga {
        // estou validando se o nome não é nulo.
        Objects.requireNonNull(name);
    }
}
