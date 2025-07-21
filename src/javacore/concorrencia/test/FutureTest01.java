package javacore.concorrencia.test;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(15);
            return 5.58D;
        });
        System.out.println(doSomething());
        try {
            var dollarResponse = dollarRequest.get(20,TimeUnit.SECONDS);
            System.out.println("Dollar: " +dollarResponse);

        } catch (Exception e) {
            throw new RuntimeException("Erro de servidor... Tente Novamente depois...");
        }
        executorService.shutdown();
    }
    private static Long doSomething(){
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum+=i;
        }
        return sum;
    }
}
