package javacore.interfaces.dominio;

public interface DataLoader {
    /*
    quaisquer método criado através de uma interface ela será public abstract
    motivo de criação é prover uma implentação
    quando estiver usando interfaces não se usa mais extends mas sim implements é o nome da interface
    quaisquer atributo criado dentro  de uma interface ele é constante ou seja ele é static final
     */

    void load();
    default void checkPermission(){
        System.out.println("Fazendo checagem de permissões... ");
    }
}
