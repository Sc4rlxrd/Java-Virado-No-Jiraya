package javacore.associacao.teste;

import javacore.associacao.dominio.Jogador;

public class JogadorTest01 {
    public static void main(String[] args) {
        Jogador jogador = new Jogador("Pelé");
        Jogador jogador2 = new Jogador("Romário");
        Jogador jogador3 = new Jogador("Neymar");
        Jogador jogador4 = new Jogador("Messi");
        Jogador [] jogadores = new Jogador[]{jogador,jogador2,jogador3, jogador4};
        for (Jogador temp: jogadores){
            temp.imprime();
        }

    }
}
