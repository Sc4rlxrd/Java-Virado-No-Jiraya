package javacore.associacao.teste;

import javacore.associacao.dominio.Jogador;
import javacore.associacao.dominio.Time;

public class JogadorTest02 {
    public static void main(String[] args) {
        Jogador jogador = new Jogador("Pelé");
        Time time = new Time("Selação Brasileira");
        jogador.setTime(time);
        jogador.imprime();
    }
}
