package javacore.sobrecargametodos.dominio;

public class Anime {
    private String tipo;
    private int episodios;
    private String nome;
    private String genero;


    // esse metodo esta sofrendo sobrecarga, esta  tendo varios parametros de tipos diferentes
    // obs: cuidado com ambiguidade da sobrecarga nao criar duas sobrecarga tendo o mesmos parametro pelo menos vai add  +1 na segunda carga
    // para funcionar o codigo certinho
    public void init(String nome, String tipo,int episodios, String genero){
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
        this.genero = genero;
    }
    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.tipo);
        System.out.println(this.episodios);
        System.out.println(this.genero);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setEpisodios(int episodios){
        this.episodios = episodios;
    }
    public String getTipo(){
        return this.tipo;
    }
    public int getEpisodios(){
        return this.episodios;
    }


}
