package javacore.colecoes.dominio;

import java.util.Objects;

public class Manga  implements Comparable<Manga> {

        private Long id;
        private String nome;
        private double preco;
        private int quntidade;

    public Manga(Long id, String nome, double preco) {
        Objects.requireNonNull(id,"Id não pode ser null");
        Objects.requireNonNull(nome,"Nome não pode ser null ");
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Manga(Long id, String nome, double preco, int quntidade) {
        this(id,nome,preco);
        this.quntidade = quntidade;
    }

    public int getQuntidade() {
        return quntidade;
    }

    public void setQuntidade(int quntidade) {
        this.quntidade = quntidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(preco, manga.preco) == 0 && Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco);
    }

    @Override
    public int compareTo(Manga outroManga) {
        // LEMBRANDO this seria a classe que está implementando o compareTo.
        // negativo se o this < outroManga
        // se this == outroManga, return 0
        // positivo se this > outroManga
        if(this.id< outroManga.getId()){
            return -1;
        } else if (this.id.equals(outroManga.getId())) {
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quntidade=" + quntidade +
                '}';
    }
}
