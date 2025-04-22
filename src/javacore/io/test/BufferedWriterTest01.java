package javacore.io.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

// File -> ok
// FileWriter -> ok
// FileReader -> ok
// BufferedWriter -> ok
// BufferedReader ->
/*
      Buffered sempre vai encapsular um fileWriter.
      E também sempre precisa terminar com um flush().
      obs. Não precisa colocar \n no final do texto porque o buffered tem um metodo para pular linha com base no OS.

 */
public class BufferedWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write("Salveee Mundo Java ASS: Guilherme");
            bw.newLine();
            bw.write("Salve linux Manjaro");
            bw.newLine();
            bw.write("openjdk-21");
            bw.newLine();
            bw.flush();

        }catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
}
