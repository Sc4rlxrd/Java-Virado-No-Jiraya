package javacore.jdbc.test;

import javacore.jdbc.dominio.Producer;
import javacore.jdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        //OBS. os mesmo comandos sql usado na classe producerRepository usando o Statement, ResultSet funciona no RowSet.
//        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("bones");
        List<Producer> producers = ProducerServiceRowSet.findAll();
        log.info("Producer: '{}'", producers);
    }
}
