package javacore.io.test;

// File -> ok
// FileWrite -> ok
// FileReader ->
// BufferedWrite ->
// BufferedReader ->

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest01 {

    public static void main(String[] args) throws IOException {
        // este append = true -> significa que ele sempre vai add no final do arquivo
        // ex: FileWriter fw = new FileWriter(file,true)
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file);) {
            fw.write("Salve java File. ASS: Guilherme\nSalve linux Manjaro");
            fw.flush();

        }catch (Exception e){
            System.out.println("Exception: " + e);
        }


    }
}
