package javacore.jdbc.test;

import javacore.jdbc.dominio.Producer;
import javacore.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("bones").build();
        Producer producer2 = Producer.builder().name("WIT STUDIO").build();
        Producer toUpdate = Producer.builder().id(24).name("Mappa").build();
        ProducerService.save(producer);
        ProducerService.delete(34);
        ProducerService.update(toUpdate);
        var producersFindAll = ProducerService.findAll();
        var producersFindByName = ProducerService.findByName("MAPPA");
        log.info("Producers: '{}'", producersFindByName);
        log.info("Producers: '{}'", producersFindAll);
        ProducerService.showProducerMetaData();
        ProducerService.showDriverMetaData();
        ProducerService.showTypeScrollWorking();
        var producerFindByNameAndToUpperCase = ProducerService.findByNameAndToUpperCase("MA");
        log.info("Producer : '{}'", producerFindByNameAndToUpperCase);
        var findByNameAndInsertWhenNotFound = ProducerService.findByNameAndInsertWhenNotFound("Ufotable");
        log.info("Producer : '{}'", findByNameAndInsertWhenNotFound);
        ProducerService.findByNameAndDelete("TOEI");

        // Usando o PreparedStatement ele meio que inibe o sql injection
        var producerFindByNamePreparedStatement = ProducerService.findByNamePreparedStatement("STUD");
        log.info("Producer : '{}'", producerFindByNamePreparedStatement);
        ProducerService.updatePreparedStatement(toUpdate);

    }
}
