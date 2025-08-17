package javacore.jdbc.test;

import javacore.jdbc.dominio.Producer;
import javacore.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Toei Animation").build();
        Producer producer2 = Producer.builder().name("WIT STUDIO").build();
        Producer toUpdate = Producer.builder().id(24).name("MAPPA").build();
//        ProducerService.save(producer);
//        ProducerService.delete(21);
//        ProducerService.update(toUpdate);
//        var producersFindAll = ProducerService.findAll();
//        var producersFindByName = ProducerService.findByName("MAPPA");
//        log.info("Producers: '{}'", producersFindByName);
//        ProducerService.showProducerMetaData();
//        ProducerService.showDriverMetaData();
//        ProducerService.showTypeScrollWorking();
//        var producerFindByNameAndToUpperCase = ProducerService.findByNameAndToUpperCase("Toei");
        var findByNameAndInsertWhenNotFound = ProducerService.findByNameAndInsertWhenNotFound("Ufotable");
        ProducerService.findByNameAndDelete("ufot");
        log.info("Producer : '{}'", findByNameAndInsertWhenNotFound);

    }
}
