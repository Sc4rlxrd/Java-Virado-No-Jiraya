package javacore.blocosinicializacao.dominio;

public class Anime {
    private String nome;
    private int [] episodios;
    // bloco de inicializacao executa antes do construtor
    // 1: alocado memória pro objeto
    // 2: cada atributo de class e inicializado com valores default ou quer for passado
    // 3: bloco de inicializaçao é executado
    // 4: construtor é executado
    {
        System.out.println("Dentro do bloco de inicializacao");
        episodios = new int [100];
        for (int i = 0; i<episodios.length; i ++){
            episodios[i] = i+1;
        }
    }

    public Anime(String nome) {
        this.nome = nome;
    }
    public Anime() {
        for(int ep: this.episodios){
            System.out.print(ep + " ");
        }
        System.out.println();
    }

    public int[] getEpisodios() {
        return episodios;
    }
    public  String getNome(){
        return nome;
    }
}
