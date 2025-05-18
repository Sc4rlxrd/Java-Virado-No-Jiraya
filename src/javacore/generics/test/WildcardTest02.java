package javacore.generics.test;

import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        // com wildcard você perde o poder add na lista
        // vai servir somente para leitura
        // obs: somente pode usar a palavra extends
        List<Cachorro> cachorros = List.of(new Cachorro(),new Cachorro());
        List<Gato> gatos = List.of(new Gato(),new Gato());
        printConsulta(cachorros);
        printConsulta(gatos);
    }
    // type erasure
    // aqui eu perco esse poder porque eu não tenho certeza que as classes filhas são realmente animais
    // porque o “output” pode ser: Cachorro, Gato ou obj por esse motivo eu perco o poder de add na lista
    private static void printConsulta(List<? extends Animal> animals){
        for(Animal animal: animals){
            animal.consulta();
        }
    }
    // aqui volto a ter poder de add na lista porque sei que é o obj vai ser do tipo animal como passado via parâmetro a class pai de animal que seria a própria classe animal
    private static void printConsultaAnimal(List<? super Animal> animals){
        animals.add(new Cachorro());
        animals.add(new Gato());
    }
}
