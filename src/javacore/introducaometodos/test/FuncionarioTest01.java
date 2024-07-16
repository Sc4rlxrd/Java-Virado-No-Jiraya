package javacore.introducaometodos.test;

import javacore.introducaometodos.dominio.Funcionario;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Sanji");
        funcionario.setIdade(23);
        funcionario.setSalario(new double[] {1200, 987.32, 2000});
        funcionario.imprimir();
        System.out.println("Média com getMedia: " + funcionario.getMedia());

    }
}
