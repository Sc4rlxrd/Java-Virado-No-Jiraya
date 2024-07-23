package javacore.enumeracao.teste;

import javacore.enumeracao.dominio.Cliente;
import javacore.enumeracao.dominio.TipoCliente;
import javacore.enumeracao.dominio.TipoPagmento;

public class ClienteTest01 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Tsubasa", TipoCliente.PESSOA_FISICA, TipoPagmento.CREDITO);
        Cliente cliente2 = new Cliente("Tsubasa",TipoCliente.PESSOA_JURIDICA,TipoPagmento.DEBITO);
        Cliente cliente3 = new Cliente("Tsubasa",TipoCliente.PESSOA_FISICA,TipoPagmento.CREDITO);
        Cliente cliente4 = new Cliente("Tsubasa",TipoCliente.PESSOA_JURIDICA,TipoPagmento.CREDITO);
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println(cliente4);
        System.out.println(TipoPagmento.CREDITO.calcularDesconto(100));
        System.out.println(TipoPagmento.DEBITO.calcularDesconto(100));

    }
}
