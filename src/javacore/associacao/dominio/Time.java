package javacore.associacao.dominio;

public class Time {
    private String nome;
    private Jogador [] jogadors;

    public Time(String nome, Jogador[] jogadors) {
        this.nome = nome;
        this.jogadors = jogadors;
    }
    public void imprime(){
        System.out.println("Time: " + this.nome);
        if(jogadors == null){
            return;
        }
        for(Jogador jogador : jogadors){
            System.out.println("Jogador: " + jogador.getNome());
        }
    }

    public Jogador[] getJogadors() {
        return jogadors;
    }

    public void setJogadors(Jogador[] jogadors) {
        this.jogadors = jogadors;
    }

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
