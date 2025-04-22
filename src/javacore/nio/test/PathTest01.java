package javacore.nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        Path p1 = Paths.get("/home/scarlxrd/Documentos/Estudos/Java/Java-Virado-No-Jiraya/file.txt");
        Path p2 = Paths.get("/home/scarlxrd/Documentos/Estudos/Java/Java-Virado-No-Jiraya","file.txt");
        Path p3 = Paths.get("/home/scarlxrd/","Documentos/Estudos/Java/Java-Virado-No-Jiraya/file.txt");
        Path p4 = Paths.get("/home/scarlxrd/Documentos/Estudos/Java","Java-Virado-No-Jiraya","file.txt");
        Path p5 = Paths.get("/home/scarlxrd","Documentos/Estudos", "Java/Java-Virado-No-Jiraya","directory2/arquivo_renomeado.txt");
        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());
        System.out.println(p4.getFileName());
        System.out.println(p5.getFileName());
        /*
            obs: do p2 em diante é usado vargs
         */

    }
}
