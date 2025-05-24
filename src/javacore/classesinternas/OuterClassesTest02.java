package javacore.classesinternas;

public class OuterClassesTest02 {
    String name = "Isagi";

    void print(){
        // o único modificador de acesso aceito é final
       final String lastName = "Yoichi";
        // os únicos modificadores de acesso aceito é ‘abstract’ ou final em uma class local
        class LocalClass{
            public void printLocal(){
                System.out.println(name+" "+lastName);
            }
        }
        new LocalClass().printLocal(); // sempre precisar instanciar a class dentro das chaves do mét0do
    }
    public static void main(String[] args) {

        OuterClassesTest02 outer = new OuterClassesTest02();
        outer.print();

    }
}
