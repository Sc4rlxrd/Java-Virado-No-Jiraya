package javacore.regex.test;

import java.util.Scanner;

public class ScannerTest02 {
    public static void main(String[] args) {
        String texto = "Levi,Eren,Mikasa,true,200,Scarlxrd,2004,false,true,GUILHERME,S22";
        Scanner scanner = new Scanner(texto);
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int i = scanner.nextInt();
                System.out.println("int: " + i);
            } else if (scanner.hasNextBoolean()) {
                boolean b = scanner.nextBoolean();
                System.out.println("boolean: " + b);

            }else{
                String text = scanner.next();
                System.out.println("Texto: " + text);
            }
        }
        
    }
}
