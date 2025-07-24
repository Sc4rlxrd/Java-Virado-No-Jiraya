package javacore.concorrencia.test;


import javacore.concorrencia.service.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();

        searchPricesAsyncCompletableFuture(storeServiceDeprecated);
    }
    private static void searchPricesAsyncCompletableFuture(StoreServiceDeprecated storeServiceDeprecated){
        long start = System.currentTimeMillis();
        // como fazer um métod0 síncrono virar um assíncrono
        // Uma dica boa que o completable Future suporta um Executor além de poder, ser sobrecarregado com um Runnable, mas somente o métod0 supplyAsync
        ExecutorService executor = Executors.newFixedThreadPool(8 , runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;

        });
        var stores = List.of("Store 1","Store 2","Store 3","Store 4");

        // forma de fazer tudo numa única linha
        List<Double> prices = stores.stream().map(s -> CompletableFuture.supplyAsync(() -> storeServiceDeprecated.getPriceSync(s),executor)).map(CompletableFuture::join).toList();


        // forma de várias linhas
        List<CompletableFuture<Double>> completableFutures = stores.stream().map(s -> CompletableFuture.supplyAsync(() -> storeServiceDeprecated.getPriceSync(s),executor)).toList();
        List<Double> prices2 = completableFutures.stream().map(CompletableFuture::join).toList();

        long end = System.currentTimeMillis();
        executor.shutdown();
        System.out.printf("Time passed to searchPricesAsyncCompletableFuture %dms%n", (end - start));

    }

}
