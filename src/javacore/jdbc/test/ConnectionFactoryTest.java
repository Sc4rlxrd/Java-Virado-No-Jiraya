package javacore.jdbc.test;

import javacore.jdbc.dominio.Producer;
import javacore.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producer2 = Producer.builder().name("WIT STUDIO").build();
        Producer toUpdate = Producer.builder().id(24).name("MAPPA").build();
//        ProducerService.save(producer2);
//        ProducerService.delete(21);
//        ProducerService.update(toUpdate);
        var producers = ProducerService.findAll();
        log.info("Producers: '{}'", producers);


    }
}
