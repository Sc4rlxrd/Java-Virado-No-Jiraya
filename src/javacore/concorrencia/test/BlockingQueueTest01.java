package javacore.concorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        // Ele necessita de um range, caso ele não tenha espaço, ele trava a thread até poder acessar ela de novo.
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        bq.put("Guilherme");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
        System.out.println("Trying to add another value ");
        new Thread(new RemoveFromQueue(bq)).start();
        bq.put("Silva");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(),bq.peek());
    }

    static class RemoveFromQueue implements Runnable{
        private final BlockingQueue<String>bq;

        RemoveFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.printf("%s going to sleep for 5s %n", Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s  removing value from queue %s%n", Thread.currentThread().getName(),bq.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
