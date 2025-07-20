package javacore.concorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        // ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue -> o LinkedTransferQueue junta essa 3 classes
        LinkedTransferQueue<Object> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Guilherme")); // ele add mais pode lançar um throws
        System.out.println(tq.offer("Guilherme")); // ele add mais não lança um throws além de sofrer sobrecarga
        System.out.println(tq.offer("Guilherme", 10, TimeUnit.SECONDS)); // o sobrecarga seria o tempo que ele vai espera para add
        tq.put("Scarlxrd"); // pode lançar um throws se for null
        if (tq.hasWaitingConsumer()) {
            tq.transfer("Scarlxrd"); // ele vai add assim que der até alguém pegar para add é pode lançar throws
        }
        System.out.println(tq.tryTransfer("RED")); // funciona da mesma forma que o exemplo de cima a diferença que está dentro do sout
        System.out.println(tq.tryTransfer("RED",5,TimeUnit.SECONDS));
        System.out.println(tq.element());  // funciona da mesma coisa que o peek() ele retorna o primeiro elemento da queue
        System.out.println(tq.peek());  // retorna o primeiro elemento da list/queue
        System.out.println(tq.poll());  // ele remove o elemento da queue é pode lançar um throws se a queue for vazia
        System.out.println(tq.remove()); // ele funciona da mesma forma que o poll()


    }
}
