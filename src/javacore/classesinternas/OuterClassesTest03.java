package javacore.classesinternas;

public class OuterClassesTest03 {
   private String name = "Boruto";
   // com o modificador estático somente posso acessar conteúdos estáticos.
   static class Nested{
       private String lastName = "Uzumaki";
        void print(){

            // assim eu consigo acessar o valor na variavel name
            System.out.println(new OuterClassesTest03().name +  lastName);
        }
   }

    public static void main(String[] args) {
        //Agora não preciso referencia a classe super, basta criar um obj padrão como no exemplo abaixo.
        Nested nested = new Nested();
        nested.print();

    }
}
