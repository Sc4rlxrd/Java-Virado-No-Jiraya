package javacore.threads.test;

import java.util.ArrayList;
import java.util.List;

class ThreadSafeNames{
    private final List<String> names = new ArrayList<>();

    public synchronized void add(String name){
        names.add(name);
    }
    public synchronized  void removeFirst(){
        if (names.size()>0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.removeFirst());
        }
    }
}
public class ThreadSafeTest01 {
    public static void main(String[] args) {
        // mesmo trabalhando com classe thread safe os medodo dela também deve ser synchronized
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Isagi Yoichi");
        // usando lambda
        Runnable r = ()->{threadSafeNames.removeFirst();};
        new Thread(r).start();
        new Thread(r).start();
    }
}
