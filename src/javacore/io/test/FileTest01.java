package javacore.io.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileTest01 {
    public static void main(String[] args) {
        File file =  new File("file.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Is Created:" + isCreated); // está criado
            boolean exists = file.exists(); // verificar se existe o arquivo
            System.out.println("path:"  + file.getPath()); // path do arquivo
            System.out.println("path absolute:"  + file.getAbsolutePath()); // path absoluto do arquivo
            System.out.println("Is directory: " + file.isDirectory()); // se esta em um diretorio
            System.out.println("Is file: " + file.isFile()); // se é um arquivo
            System.out.println("Is hidden: " + file.isHidden()); // se está oculto o arquivo
            System.out.println("Last modified: " +  Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDate()); // a última vez que foi modificado
            if (exists){
                System.out.println("Is deleted: " + file.delete());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
