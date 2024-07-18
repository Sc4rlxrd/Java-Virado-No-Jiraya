package javacore.construtores.dominio;

public class Anime {
    private String tipo;
    private int episodios;
    private String nome;
    private String genero;
    private String estudio;

    // obs tem duas regras
    // 1: o this de referencia de construtor so pode ser usado dentro do bloco de algum construtor
    // 2: ele obrigadoriamente precisa ser colocado na primeira linha se causa colocar sout antes do this que o code
    //construtor nao tem retorno
    // ele sempre vai iniciar na frete de tudo
    public  Anime(String nome, String tipo,int episodios, String genero){
        //add um construtor dentro de outro
        this();

        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
        this.genero = genero;

    }
    // sobrecarga de construtor
    public Anime(String nome, String tipo,int episodios, String genero,String estudio){
        // delega argumentos com outro construtor com o uso do this
        this(nome, tipo, episodios, genero);
        this.estudio = estudio;
    }

    public Anime(){
        System.out.println("Dentro construtor sem argumentos");
    }


    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.tipo);
        System.out.println(this.episodios);
        System.out.println(this.genero);
        System.out.println(this.estudio);
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

