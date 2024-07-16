package javacore.introducaometodos.test;

import javacore.introducaometodos.dominio.Pessoa;

public class PessoaTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        // modificador de acesso private te obriga criar set e get para acessar os valores do atributos da variavel de uma class sem psvm
        // pessoa.name ="Jiraya";
        // pessoa.age = 70;
        //pessoa.imprime();

        pessoa.setName("Gon");
        pessoa.setAge(25);
        System.out.println("Prazer: " + pessoa.getName());
        System.out.println("Nem parece " + pessoa.getAge() + " anos");
    }
}
