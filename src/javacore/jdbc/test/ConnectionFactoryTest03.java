package javacore.jdbc.test;


import javacore.jdbc.dominio.Producer;
import javacore.jdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Toei Animation").build();
        Producer producer2 = Producer.builder().name("White fox").build();
        Producer producer3 = Producer.builder().name("Studio Ghibli").build();
        ProducerService.saveTransaction(List.of(producer1,producer2,producer3));
//        ProducerService.delete(38);
//        ProducerService.delete(39);
//        ProducerService.delete(40);
    }
}
