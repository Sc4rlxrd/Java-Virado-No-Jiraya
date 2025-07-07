package javacore.concorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock(); // pega o lock manualmente, mas lembre de sempre libera ele no final da execução
        try {
            System.out.printf("Thread %s entrou em sessão crítica%n", name);
            System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength());
            System.out.printf("Thread %s vai esperar 2s%n", name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera%n", name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // throw do mét0do sleep
        } finally {
            lock.unlock(); // liberei o lock
        }

    }
}

public class ReentrantLockTest01 {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true); // true no constructor faz ele passar o acesso para a thread mais tempo esperando
        new Thread(new Worker("A",lock)).start();
        new Thread(new Worker("B",lock)).start();
        new Thread(new Worker("C",lock)).start();
        new Thread(new Worker("D",lock)).start();
        new Thread(new Worker("F",lock)).start();
        new Thread(new Worker("G",lock)).start();

    }
}
