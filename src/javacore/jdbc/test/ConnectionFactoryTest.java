package javacore.jdbc.test;

import javacore.jdbc.conn.ConnectionFactory;
import javacore.jdbc.dominio.Producer;
import javacore.jdbc.repository.ProducerRepository;

public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Producer producer1 = Producer.ProducerBuilder.builder().name("NHK").build();
        Producer producer2 = Producer.ProducerBuilder.builder().name("WIT STUDIO").build();
        Producer producer3 = Producer.ProducerBuilder.builder().name("MAPPA").build();
        Producer producer4= Producer.ProducerBuilder.builder().name("UFOTABLE").build();
//        ProducerRepository.save(producer1);
        ProducerRepository.save(producer2);
        ProducerRepository.save(producer3);
        ProducerRepository.save(producer4);
    }
}
