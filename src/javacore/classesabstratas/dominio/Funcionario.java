package javacore.classesabstratas.dominio;

public  abstract class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        calculaBonus();
    }
    // vai obrigar a implementar o método calculaBonus em toda class que estender de funcionario
    public  abstract void calculaBonus();

}
