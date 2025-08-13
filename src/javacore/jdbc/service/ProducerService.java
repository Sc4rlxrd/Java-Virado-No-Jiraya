package javacore.jdbc.service;

import javacore.jdbc.dominio.Producer;
import javacore.jdbc.repository.ProducerRepository;

public class ProducerService {
    public static  void save(Producer producer){
        ProducerRepository.save(producer);
    }
    public static void delete(Integer id){
        requireValid(id);
        ProducerRepository.delete(id);
    }
    public static  void update(Producer producer){
        requireValid(producer.getId());
        ProducerRepository.update(producer);
    }
    private static void requireValid(Integer id){
        if (id == null || id<=0){
            throw new IllegalArgumentException("Invalid value for id");

        }
    }
}
