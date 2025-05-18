package javacore.generics.test;

abstract  class Animal{
    public abstract void consulta();
}
class Cachorro extends Animal{
    @Override
    public void consulta() {
        System.out.println("Consultando doguinho");
    }
}
class Gato extends Animal{
    @Override
    public void consulta() {
        System.out.println("Consultando gatinho");
    }
}

public class WildcardTest01 {
    public static void main(String[] args) {
        // com arrays não tem problema porque ele sabe,
        // mas quando começa a mexer com lista devido ao type erasure ele lança exception
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(),new Gato()};
        printConsulta(cachorros);
        printConsulta(gatos);

    }
    private static void printConsulta(Animal[] animals){
        for(Animal animal: animals){
            animal.consulta();
        }
    }

}
