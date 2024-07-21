package javacore.associacao.teste;

import javacore.associacao.dominio.Jogador;
import javacore.associacao.dominio.Time;

public class JogadorTest03 {
    public static void main(String[] args) {
        Jogador jogador = new Jogador("Cafu");
        Jogador jogador2 = new Jogador("Pelé");
        Jogador jogador3 = new Jogador("Neymar");
        Time time = new Time("Brasil");
        Time time2 = new Time("Barcelona");
        Jogador [] jogadores = {jogador,jogador2,jogador3};

        jogador.setTime(time);
        jogador2.setTime(time);
        jogador3.setTime(time2);
        time.setJogadors(jogadores);

        System.out.println("----- JOGADOR ------");
        jogador.imprime();
        jogador2.imprime();
        jogador3.imprime();

        System.out.println("----- TIME ------");
        time.imprime();
        time2.imprime();
    }
}
