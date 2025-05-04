package javacore.serializacao.dominio;

import java.io.Serializable;

public class Aluno implements Serializable {
        private Long id;
        private String nome;
        private String password;

    public Aluno(Long id, String nome, String password) {
        System.out.println("Dentro do construtor.");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return STR."Aluno{id=\{id}, nome='\{nome}', password='\{password}'}";
    }
}
