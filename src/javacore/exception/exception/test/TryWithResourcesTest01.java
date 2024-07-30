package javacore.exception.exception.test;

import javacore.exception.exception.dominio.Leitor1;
import javacore.exception.exception.dominio.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {
        lerArquivo3();


    }

    // try de recursos
    public static  void lerArquivo(){
        try (Reader reader = new BufferedReader(new FileReader("teste.txt"))){

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void lerArquivo2(){
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // multi instancias dentro do try resources obs lembra de colocar ponto é virgula
    public static  void lerArquivo3(){
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2()){

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
