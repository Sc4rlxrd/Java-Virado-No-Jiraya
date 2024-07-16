package javacore.introducaometodos.dominio;



public class Funcionario {
    public String nome;
    public int idade;
    public double[] salario;

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
        double media = 0;
        if(salario!=null){
            for(double temp:salario){
                media+=temp;
            }
            media/=salario.length;
        }

        System.out.println("Média salarial: " + media);
    }

}
