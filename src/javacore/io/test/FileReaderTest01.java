package javacore.io.test;

import java.io.File;
import java.io.FileReader;

// File -> ok
// FileWrite -> ok
// FileReader -> ok
// BufferedWrite ->
// BufferedReader ->
public class FileReaderTest01 {
    public static void main(String[] args) {

        File file = new File("file.txt");
        try(FileReader fr = new FileReader(file)) {
//            char[] in = new char[51];
//            fr.read(in);
//            for (char c : in){
//                System.out.print(c);
//            }
            int i;
            while((i=fr.read())!= -1){
                System.out.print((char) i);
            }

        }catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
}
