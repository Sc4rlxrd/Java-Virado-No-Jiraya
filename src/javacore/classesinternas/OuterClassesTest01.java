package javacore.classesinternas;

public class OuterClassesTest01 {
    private String name = "Monkey D. Luffy";
    private String name2 = "Isagi Yoichi";


    class Inner{
        public void printOuterClassAttribute(){
            System.out.println(name);
            System.out.println(name2);
            System.out.println(this); // ele faz referência para class inner
            System.out.println(OuterClassesTest01.this); // ele faz referência a class outer que seria a mais externa
        }
    }
  // obs
    public static void main(String[] args) {
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        Inner inner = outerClass.new Inner();
        inner.printOuterClassAttribute();
        // Segunda forma de usar class interna também
        Inner inner2 = new OuterClassesTest01().new Inner();
        inner2.printOuterClassAttribute();

    }
}
