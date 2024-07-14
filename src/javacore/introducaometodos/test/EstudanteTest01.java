package javacore.introducaometodos.test;

import javacore.introducaometodos.dominio.Estudante;
import javacore.introducaometodos.dominio.ImpressoraEstudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();
        ImpressoraEstudante impressora = new ImpressoraEstudante();

        estudante01.nome="Itadori";
        estudante01.idade = 18;
        estudante01.sexo='M';
        estudante02.nome="Meliodas";
        estudante02.idade= 3000;
        estudante02.sexo='M';
        System.out.println("=========================");
        impressora.imprime(estudante02);
        System.out.println("==========================");
        impressora.imprime(estudante01);

    }
}
