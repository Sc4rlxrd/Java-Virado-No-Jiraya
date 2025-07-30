package javacore.concorrencia.test;

import javacore.concorrencia.dominio.Quote;
import javacore.concorrencia.service.StoreServiceWithDiscount;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class CompletableFutureTest05 {
    public static void main(String[] args) {
        // allOf e anyOf ele espera um Vargas um array lembrando que qualquer um dos dois retorna um CompletableFuture
        // allOf ⇾ espera todas CompletableFutures terminar e executa / mostra se terminou
        // anyOf ⇾ quando o primeiro CompletableFutures terminar para tod0 programa
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        var completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                // thenAccept faz uma ação que seria executar o souf
                .map(cf -> cf.thenAccept(s -> System.out.printf("%s finished in %d%n", s, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> voidCompletableFutureAllOf = CompletableFuture.allOf(completableFutures);
        CompletableFuture<Object> voidCompletableFutureAnyOf = CompletableFuture.anyOf(completableFutures);
        voidCompletableFutureAllOf.join();
        voidCompletableFutureAnyOf.join();
        System.out.printf("Finished? %b%n", voidCompletableFutureAllOf.isDone());
        System.out.printf("Finished? %b%n", voidCompletableFutureAnyOf.isDone());

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesWithDiscountAsync  %dms%n", (end-start));
    }

}
