package javacore.introducaometodos.test;

import javacore.introducaometodos.dominio.Estudante;

public class EstudanteTest02 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();

        estudante01.nome="Itadori";
        estudante01.idade = 18;
        estudante01.sexo='M';
        estudante02.nome="Meliodas";
        estudante02.idade= 3000;
        estudante02.sexo='M';

        estudante01.imprime();
        estudante02.imprime();


    }

}
