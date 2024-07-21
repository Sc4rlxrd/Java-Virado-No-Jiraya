package javacore.associacao.teste;

import java.util.Scanner;

public class LeituraDoTecladoTest02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("O grande software de previsão do futuro...");
        System.out.println("Digite sua pergunta  e eu responderei sim ou não ");
        String ask = input.nextLine();
        if(ask.charAt(0) == ' '){
            System.out.println("Sim");
        }else {
            System.out.println("Não");
        }

    }
}
