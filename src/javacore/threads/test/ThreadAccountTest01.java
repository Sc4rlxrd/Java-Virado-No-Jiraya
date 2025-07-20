package javacore.threads.test;

import javacore.threads.dominio.Account;

public class ThreadAccountTest01 implements Runnable {
    // o synchronized vai fazer thread terminar até o final do código quando terminar a outra thread vai poder executar a lógica
    // pode usar o na declaração do metodo ou dentro do metodo
    /*
       OBS: se for dentro do metodo a class deve ter instancia final

         private void withdrawal (int amount){
            synchronized(account){
              if (account.getBalance()>=amount){
                    System.out.println(STR."\{Thread.currentThread().getName()} está indo sacar dinheiro");
                    account.withdrawal(amount);
                    System.out.println(STR."\{Thread.currentThread().getName()} completou o saque, o valor atual da conta \{account.getBalance()}");
               }else {
                        System.out.println(STR."Sem dinheiro para \{Thread.currentThread().getName()} efetuar o saque \{account.getBalance()}");
        }
            }

      }
     */
    Account account = new Account();
    public static void main(String[] args) {
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01,"Hestia");
        Thread t2 = new Thread(threadAccountTest01,"Bell Cranel");
        t1.start();
        t2.start();
    }
    private synchronized void withdrawal (int amount){
        if (account.getBalance()>=amount){
            System.out.println(Thread.currentThread().getName() + " está indo sacar dinheiro");
            account.withdrawal(amount);
            System.out.println(Thread.currentThread().getName() + "completou o saque, o valor atual da conta " + account.getBalance());
        }else {
            System.out.println("Sem dinheiro para "+Thread.currentThread().getName()+ " efetuar o saque "+ account.getBalance());
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if (account.getBalance()<0){
                System.out.println("FODEO");
            }
        }
    }
}
