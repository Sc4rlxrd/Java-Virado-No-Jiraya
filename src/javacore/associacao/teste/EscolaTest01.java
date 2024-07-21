package javacore.associacao.teste;

import javacore.associacao.dominio.Escola;
import javacore.associacao.dominio.Professor;

public class EscolaTest01 {
    public static void main(String[] args) {
        Professor professor = new Professor("Jiraya");
        Professor professo2 = new Professor("Kakashi");
        Professor professor3 = new Professor("yamato");
        Professor [] professors = {professor,professo2,professor3};
        Escola escola = new Escola("konoha", professors);
        escola.imprime();
    }
}
