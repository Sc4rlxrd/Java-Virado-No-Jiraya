package javacore.strings.test;

public class StringTest02 {
    public static void main(String[] args) {
        // alguns métodos da classe string que vai facilitar o manuseio delas

        String name = "Luffy";
        String number = "012345";

        System.out.println(name.charAt(2));
        System.out.println(name.length());
        System.out.println(name.replace("f","l"));
        System.out.println(name.toLowerCase());
        System.out.println(name.toUpperCase());
        System.out.println(name.trim()); // tira os espaços brancos
        System.out.println("=====================");
        System.out.println(number.length());
        System.out.println(number.substring(0,3)); // não vai mostrar o valor no index 3
        System.out.println(number.substring(0,number.length())); // vai mostrar até o valor
        System.out.println(number.substring(0)); // pode usar assim também vai funcionar igual o de cima


    }
}
