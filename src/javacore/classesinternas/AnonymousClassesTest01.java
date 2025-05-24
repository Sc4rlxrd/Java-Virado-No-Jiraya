package javacore.classesinternas;

class Animal{
    public void walk(){
        System.out.println("Animal walking");
    }
}
public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        // classe anônima que tem um ciclo de vida menor onde ele só vai executar num pequeno pedaço de código
        Animal dog = new Animal(){
            @Override
            public void walk() {
                System.out.println("dog walking in the shadows.");
            }
        };
        dog.walk();
    }
}
