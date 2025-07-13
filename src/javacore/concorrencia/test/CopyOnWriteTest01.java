package javacore.concorrencia.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteTest01 {
    public static void main(String[] args) {
        // Como funcionar: imagine uma lista com esses elementos [1,2,3,4] Agora, você quer remover o valor 4. Ele copia esta lista e elimina o valor 4 da lista e retorna à lista como [1,2,3] caso decida remover outro valor, ele vai repetir esse processo de novo.
        // A forma que iterator age com o arrayList é a mesma forma de agir com o copyOnWrite
        // List<Integer> list = new CopyOnWriteArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            list.add(i);
        }
        Runnable runnableIterator = ()->{
            Iterator<Integer> iterator = list.iterator();
            try{
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable runnableRemover = ()->{
            for (int i = 0; i < 800; i++) {
                System.out.printf("%s  removed  %d%n", Thread.currentThread().getName(),i);
            }
        };

        new Thread(runnableIterator).start();
        new Thread(runnableIterator).start();
        new Thread(runnableRemover).start();
    }
}
