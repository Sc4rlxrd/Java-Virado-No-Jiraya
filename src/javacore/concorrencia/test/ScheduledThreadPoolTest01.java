package javacore.concorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest01 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static void beeper(){
        Runnable r = ()->{
            System.out.println(LocalTime.now().format(formatter)+ " -> beep");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
//        executor.schedule(r,3, TimeUnit.SECONDS); → ele precisa de runnable e um delay que seria o tempo da próxima ação
        // scheduleWithFixedDelay ele não conta o sleep anterior como no lambda acima dorme 5 quando chegar em baixo vai dormir por mais 5 e vai prosseguir
        // scheduleWithFixedRate ele é o inverso ele conta o sleep do lambda então quando a thread agora ele já vai lançar o beep
        ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);
        executor.schedule(()->{
            System.out.println("Cancelando o scheduleWithFixedDelay");
            scheduleWithFixedDelay.cancel(false);
            executor.shutdown();
        },20,TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }
}
