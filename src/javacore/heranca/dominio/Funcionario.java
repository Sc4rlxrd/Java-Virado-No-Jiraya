package javacore.heranca.dominio;

public class Funcionario extends Pessoa {
    private double salario;

    static {
        System.out.println("Dentro do bloco  inicializacao estatico de funcionario");
    }
    {
        System.out.println("Dentro do bloco sem ser inicializacao ou do construtor Funcionario 1");
    }
    {
        System.out.println("Dentro do bloco sem ser inicializacao ou do construtor Funcionario 2");

    }

    public Funcionario(String nome){
        super(nome);
        System.out.println("Dentro do construtor de Funcionario");
    }

    @Override
    public void imprime() {
        super.imprime();
        System.out.println("Salário: " + this.salario);
    }
    public void imprimeRelatorio(){
        System.out.println("Eu: " + this.nome + " recebi o salário de  " + this.salario);
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
