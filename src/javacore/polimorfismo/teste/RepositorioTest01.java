package javacore.polimorfismo.teste;

import javacore.polimorfismo.repositorio.Repositorio;
import javacore.polimorfismo.servico.RepositorioArquivo;
import javacore.polimorfismo.servico.RepositorioBancoDeDados;
import javacore.polimorfismo.servico.RepositorioMemoria;

public class RepositorioTest01 {
    public static void main(String[] args) {
        Repositorio repositorio = new RepositorioBancoDeDados();
        Repositorio repositorio2 = new RepositorioArquivo();
        Repositorio repositorio3 = new RepositorioMemoria();
        repositorio.salvar();
        repositorio2.salvar();
        repositorio3.salvar();


    }
}
