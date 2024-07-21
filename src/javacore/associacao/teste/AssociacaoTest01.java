package javacore.associacao.teste;

import javacore.associacao.dominio.Aluno;
import javacore.associacao.dominio.Local;
import javacore.associacao.dominio.Professor;
import javacore.associacao.dominio.Seminario;

public class AssociacaoTest01 {
    public static void main(String[] args) {
        Local local = new Local("Rua das laranjeiras");
        Aluno aluno = new Aluno("Luffy",20);
        Aluno aluno2 = new Aluno("zoro",21);
        Professor professor = new Professor("Barba Branca", "Pirata");
        Professor professor2 = new Professor("Mihawk", "Pirata");
        Aluno[] alunosParaSeminario={aluno,aluno2};
       // Aluno[] alunosParaSeminario={};

        Seminario seminario = new Seminario("Onde achar one piece",alunosParaSeminario,local);
        Seminario seminario2 = new Seminario("Como se tornar o melhor espadachim",alunosParaSeminario,local);
        Seminario[] seminariosDisponivel = {seminario};
        Seminario []seminariosDisponivel2={seminario2};

        professor.setSeminarios(seminariosDisponivel);
        professor2.setSeminarios(seminariosDisponivel2);
        professor.imprime();
        professor2.imprime();

    }
}
