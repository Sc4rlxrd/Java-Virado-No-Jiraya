package javacore.threads.test;



class ThreadExample extends Thread{
    private final char c;
    public ThreadExample(char c){
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
        }
    }
}
class ThreadExampleRunnable implements Runnable{
    private final char c;
    public ThreadExampleRunnable(char c){
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
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadTest01 {
    // existem dois tipos de thread que são Daemon X ‘User’
    public static void main(String[] args) {
        // a melhor forma de criar uma thread é implementando a interface Runnable

//        ThreadExample t1 =new ThreadExample('A');
//        ThreadExample t2 =new ThreadExample('B');
//        ThreadExample t3 =new ThreadExample('C');
//        ThreadExample t4 =new ThreadExample('D');

        // pode por nome nas threads so que esses nomes vão aparece somente no terminal
          Thread t1 = new Thread(new ThreadExampleRunnable('A'),"T1A" );
          Thread t2 = new Thread(new ThreadExampleRunnable('B'),"T2B"  );
          Thread t3 = new Thread(new ThreadExampleRunnable('C'),"T3C"  );
          Thread t4 =  new Thread(new ThreadExampleRunnable('D') ,"T4D" );
          // tem um mét0do que seta a prioridade da thread mais na maioria das vezes não funciona
        t4.setPriority(Thread.MAX_PRIORITY); // equivale 10
        t3.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(Thread.NORM_PRIORITY); // 5
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("-----------------------------------------------------------");
        System.out.println(Thread.currentThread().getName());
        // tem o mét0do sleep que põe para dormir
    }
}
