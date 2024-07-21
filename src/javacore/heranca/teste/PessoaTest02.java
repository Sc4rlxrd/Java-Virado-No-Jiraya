package javacore.heranca.teste;

import javacore.heranca.dominio.Funcionario;

public class PessoaTest02 {
    // 0 - bloco de inicialização estático da superclasse é executado quando JVM carregar classe pai
    // 1 - bloco de inicialização estático da subclasse é executado quando a JVM carregar classe filha
    // 2 - alocado espaço em memória pra objeto da superclass
    // 3 - cada atributo de superclass é criado e inicializado com valores default ou quer passado
    // 4 - bloco de inicialização da superclass é executado na ordem que aparece
    // 5 - construtor é executado da superclass
    // 6 - alocado espaço em memória pra objeto da subclass
    // 7 - cada atributo de subclass é criado e inicializado com valores default ou quer passado
    // 8 - bloco de inicialização da subclass é executado na ordem que aparece
    // 9 - construtor é executado da subclass
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Pelé");
    }
}
