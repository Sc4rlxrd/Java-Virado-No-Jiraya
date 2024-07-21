package javacore.associacao.dominio;

public class Jogador {
    private String nome;
    private Time time;
    public void imprime(){
        if(time!=null){
            System.out.println("Time: " + time.getNome());
        }
        System.out.println("Jogador: " + this.nome);
    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
