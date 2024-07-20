package javacore.modificadorestatico.dominio;
// modificador estatico afeta toda class nao so as instancias de obj  criado dela
// o metodo static faz os atributos da class partilhar junto com as variaveis de referencias
public class Carro {
    private String nome;
    private double velocidadeMaxima;
    private    static double velocidadeLimite = 250;

    public void imprime(){
        System.out.println("===========================");
        System.out.println("Nome: " + this.nome);
        System.out.println("Velocidade máxima: "  + this.velocidadeMaxima);
        System.out.println("Velocidade limite: "  + Carro.velocidadeLimite);
    }
    public Carro(){}

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }
    public static  void setVelocidadeLimite(double velocidadeLimite){
        Carro.velocidadeLimite = velocidadeLimite;
    }
    public static double getVelocidadeLimite(){
        return Carro.velocidadeLimite;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }


}
