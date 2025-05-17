package javacore.colecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");
        while (!fila.isEmpty()){
            // esse .poll() faz "order" da fila com base no compareTo da classe ‘String’ como tod o lema de fila o primeiro a entrar e o primeiro a sair
            // ele compara os valores e retorna, mas nem sempre saí na ordem certa sempre fique de olho
            System.out.println(fila.poll());
        }

    }
}
