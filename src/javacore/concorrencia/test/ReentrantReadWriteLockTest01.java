package javacore.concorrencia.test;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite{
    private final Map<String,String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock rwl;

    MapReadWrite(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void put(String key, String value){
        // criar um lock de escrita
        rwl.writeLock().lock();
        try{
            if(rwl.isWriteLocked()){
                System.out.printf("%s  got WRITE lock%n", Thread.currentThread().getName());
            }
            map.put(key, value);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // fecha o lock criado acima
            rwl.writeLock().unlock();
        }
    }

    public Set<String> allkeys(){
        // criou um lock de leitura
        rwl.readLock().lock();
        try {
            return map.keySet();
        }finally {
            rwl.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        MapReadWrite mapReadWrite = new MapReadWrite(rwl);
        Runnable writer = ()->{
            for (int i = 0; i < 20; i++) {
                mapReadWrite.put(String.valueOf(i),String.valueOf(i));
            }
        };
        Runnable reader = ()->{
            if(rwl.isWriteLocked()){
                System.out.println("WRITE LOCKED");
            }
            rwl.readLock().lock();
            System.out.println("FINALLY  I GOT THE DAMN LOCK");
            try{
                System.out.println(Thread.currentThread().getName() +" "+ mapReadWrite.allkeys());
            }finally {
                rwl.readLock().unlock();
            }
        };
        // obs varias threads pode ser de leitura, mas somente um thread pode ser a escrita
        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(reader);
        t1.start();
        t2.start();
        t3.start();
    }
}
