package javacore.modificadorestatico.dominio;

public class Anime {
    private String nome;
    private static int  [] episodios;
    // bloco de inicializacao executa antes do construtor
    // 0: o bloco de inicialização é excutado quando a JVM carregar a classe
    // 1: alocado memória pro objeto
    // 2: cada atributo de class e inicializado com valores default ou quer for passado
    // 3: bloco de inicializaçao é executado
    // 4: construtor é executado

    // usar o bloco basta usar a palavra static
    // ela é carregada antes da propria class pela jvm
   // se estiver +1 bloco estatico ele vai ser executado na ordem que aparece no code
    static {
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
        for(int ep: Anime.episodios){
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
