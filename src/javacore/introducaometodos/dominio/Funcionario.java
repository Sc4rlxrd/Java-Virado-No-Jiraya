package javacore.introducaometodos.dominio;


public class Funcionario {
    private String nome;
    private int idade;
    private double[] salario;
    private double media;

    public void imprimir(){
        System.out.println(this.nome);
        System.out.println(this.idade);
        if(salario!= null){
            for(double temp: salario){
                System.out.println(temp);
            }
        }
        imprimeMediaSalario();

    }

    public void imprimeMediaSalario(){
        if(salario!=null){
            for(double temp:salario){
                media+=temp;
            }
            media/=salario.length;
        }

        System.out.println("Média salarial: " + media);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getSalario() {
        return salario;
    }

    public void setSalario(double[] salario) {
        this.salario = salario;
    }

    public double getMedia() {
        return media;
    }

}
