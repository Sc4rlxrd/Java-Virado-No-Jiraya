package javacore.jdbc.test;

import javacore.jdbc.conn.ConnectionFactory;
import javacore.jdbc.dominio.Producer;
import javacore.jdbc.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;


public class ConnectionFactoryTest {
    public static void main(String[] args) {
       Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producer2 = Producer.builder().name("WIT STUDIO").build();
        Producer producer3 = Producer.builder().name("MAPPA").build();
        Producer producer4 = Producer.builder().name("UFOTABLE").build();
        ProducerRepository.save(producer);
        ProducerRepository.save(producer2);
        ProducerRepository.save(producer3);
        ProducerRepository.save(producer4);

    }
}
