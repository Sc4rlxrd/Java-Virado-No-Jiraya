package javacore.threads.test;

class ThreadExampleRunnable2 implements Runnable{
    private final String c;
    public ThreadExampleRunnable2(String c){
        this.c = c;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i<500; i++){
            System.out.print(c);
            if(i%100 == 0 ){
                System.out.println();
            }
            Thread.yield();
        }
    }
}

public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {

    // metodo join ele espera thread terminar para liberar a thread 2 poder prosseguir
    // metodo yield ele fazer a thread dá uma segurada no processamento e deixar a thread 2 prosseguir
        Thread t1 = new Thread(new ThreadExampleRunnable2("KA"));
        Thread t2 = new Thread(new ThreadExampleRunnable2("ME"));
        t1.start();
        t1.join();
        t2.start();

    }
}
