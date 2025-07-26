package javacore.concorrencia.test;


import javacore.concorrencia.dominio.Quote;
import javacore.concorrencia.service.StoreServiceWithDiscount;

import java.util.List;

public class CompletableFutureTest04 {
    public static void main(String[] args) {

        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscount(service);
    }
    private static void searchPricesWithDiscount(StoreServiceWithDiscount service) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
//        stores.forEach(s -> System.out.println(service.getPriceSync(s)));
        stores.stream()
                .map(service::getPriceSync) //store:price:code
                .map(Quote::newQuote)
                .map(service::applyDiscount)
                .forEach(System.out::println);
    }

}
