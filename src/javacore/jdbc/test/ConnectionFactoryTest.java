package javacore.jdbc.test;

import javacore.jdbc.conn.ConnectionFactory;
import javacore.jdbc.dominio.Producer;
import javacore.jdbc.repository.ProducerRepository;
import javacore.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;


public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producer2 = Producer.builder().name("WIT STUDIO").build();
        Producer producer3 = Producer.builder().name("MAPPA").build();
//        ProducerService.save(producer);
//        ProducerService.save(producer2);
//        ProducerService.save(producer3);
        ProducerService.delete(21);
        ProducerService.delete(22);
        ProducerService.delete(23);


    }
}
