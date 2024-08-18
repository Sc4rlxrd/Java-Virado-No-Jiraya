package javacore.strings.test;

public class StringTest01 {
    public static void main(String[] args) {
        // Strings são imutáveis
        String name = "Guilherme"; // string constant pool
        String name2 = "Guilherme";
        name = name.concat(" Santos"); // I will be adding one more word to the variable using the concat method
        System.out.println(name);
        System.out.println(name.equals(name2));
        String name3 = new String("Guilherme");
        System.out.println(name2.equals(name3));
        System.out.println(name2.equals(name3.intern()));

    }
}
