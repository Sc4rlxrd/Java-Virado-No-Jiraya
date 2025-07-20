package javacore.concorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    public boolean isOpen() {
        return open;
    }

    public int pendingEmails(){
        lock.lock();
        try {
            return this.emails.size();
        }finally {
            lock.unlock();
        }
    }
    public void addMemberEmail(String email){
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "Added email to list");
            this.emails.add(email);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "checking if there are emails ");
        try {
            while(this.emails.isEmpty()){
                if(!open) return null;

                System.out.println(Thread.currentThread().getName() + "There is no email available on the list, entering standby mode . ");
                condition.await();

            }
            return this.emails.poll();
        }finally {
            lock.unlock();
        }

    }
    public void close(){
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "Notifying everyone that we are not accepting emails. ");
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}
