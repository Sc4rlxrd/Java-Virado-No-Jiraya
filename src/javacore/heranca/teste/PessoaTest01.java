package javacore.heranca.teste;

import javacore.heranca.dominio.Endereco;
import javacore.heranca.dominio.Funcionario;
import javacore.heranca.dominio.Pessoa;

public class PessoaTest01 {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua 3");
        endereco.setCep("012345-209");
        Pessoa pessoa = new Pessoa("Toyohisa Shimazu");

        pessoa.setCpf("111111111");
        pessoa.setEndereco(endereco);
        pessoa.imprime();
        System.out.println("======================");
        Funcionario funcionario = new Funcionario("Scar");

        funcionario.setCpf("123456-89");
        endereco.setRua("Rua 45");
        endereco.setCep("22222222");
        funcionario.setEndereco(endereco);
        funcionario.setSalario(200000);
        funcionario.imprime();
    }
}
