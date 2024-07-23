package javacore.enumeracao.dominio;



public class Cliente {
    private String nome;
    private TipoPagmento tipoPagmento;
    private TipoCliente tipoCliente;

    public Cliente(String nome, TipoCliente tipoCliente, TipoPagmento tipoPagmento) {
        this.nome = nome;
        this.tipoPagmento = tipoPagmento;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipoPagmento=" + tipoPagmento +
                ", tipoCliente=" + tipoCliente +
                '}';
    }

    public TipoPagmento getTipoPagmento() {
        return tipoPagmento;
    }

    public void setTipoPagmento(TipoPagmento tipoPagmento) {
        this.tipoPagmento = tipoPagmento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
