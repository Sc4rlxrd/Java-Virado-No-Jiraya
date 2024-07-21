package javacore.modificadorfinal.dominio;


public  class Carro {
    // convencao ao usar o modificador final(vulgo constante) é escrever tudo em capslock como no exemplo abaixo
    // sempre nessa ordem abaixo
    // tem como iniciar usando o bloco estatico
    private String nome;
    public static final double VELOCIDADE_LIMITE=250;
    public final Comprador COMPRADOR = new Comprador();

    public final void imprime(){
        System.out.println(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
