package javacore.classesabstratas.teste;

import javacore.classesabstratas.dominio.Desenvolvedor;
import javacore.classesabstratas.dominio.Funcionario;
import javacore.classesabstratas.dominio.Gerente;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        // class abstract obrigatoriamente tem que ser Estendida
        // obs não pode usar new numa class abstract e nem final
        // dentro de uma class abstract pode ter métodos concretos e abstracts
        Gerente gerente = new Gerente("Nami",5000);
        System.out.println(gerente);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Scarlxrd", 12000);
        System.out.println(desenvolvedor);

    }
}
