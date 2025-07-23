package javacore.concorrencia.test;

import javacore.concorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();

        searchPricesAsyncCompletableFuture(storeService);
    }
    private static void searchPricesAsyncCompletableFuture(StoreService storeService) throws RuntimeException {
        long start = System.currentTimeMillis();
        var stores = List.of("Store 1","Store 2","Store 3","Store 4");
        // assim ele vai roda em várias threads
        List<CompletableFuture<Double>> completableFutures = stores.stream().map(storeService::getPriceAsyncCompletableFuture).toList();
        completableFutures.stream().map(CompletableFuture::join).toList();

        //  Agora ela vai uma coisa de cada vez, o gargalo desse processo seriam as operações intermediárias.
        stores.stream().map(storeService::getPriceAsyncCompletableFuture).map(CompletableFuture::join).toList();

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesAsyncCompletableFuture %dms%n", (end - start));

    }

}
