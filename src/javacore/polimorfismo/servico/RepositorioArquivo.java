package javacore.polimorfismo.servico;

import javacore.polimorfismo.repositorio.Repositorio;

public class RepositorioArquivo implements Repositorio {
    @Override
    public void salvar() {
        System.out.println("Salvando em Arquivo");
    }
}
