package javacore.wrappers.test;

public class WrapperTest01 {
    public static void main(String[] args) {
        //wrapper é um obj que  encapsular um tipo primitivo para se torna um obj
        // wrapper trabalha usando os conceitos do  polimorfismo, exemplo um wrapper long não vai aceitar um valor int por nao ser mais um tipo primitivo mas sim obj
        // pt2: autoboxing transformar um tipo primitivo em wrapper já unboxing é o contrário é transformar um wrapper em primitivo

        Byte byteW =1;
        Short shortW=1;
        Integer integerW=1; // autoboxing
        Long longW=10L;
        Float floatW=10F;
        Double doubleW=10D;
        Character charW='W';
        Boolean booleanW = false;

        int i = integerW; // unboxing
        Integer intW2 = Integer.parseInt("1");
        boolean verdadeiro = Boolean.parseBoolean("TruE");

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('!'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('A'));


    }
}
