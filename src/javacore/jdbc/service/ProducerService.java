package javacore.jdbc.service;

import javacore.jdbc.dominio.Producer;
import javacore.jdbc.repository.ProducerRepository;

import java.util.List;

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
    public static List<Producer> findAll (){
       return ProducerRepository.findAll();
    }
    public static List<Producer> findByName(String name){
       return ProducerRepository.findByName(name);
    }
    private static void requireValid(Integer id){
        if (id == null || id<=0){
            throw new IllegalArgumentException("Invalid value for id");

        }
    }
}
