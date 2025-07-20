package javacore.nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;


public class RelativizeTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/scarlxrd");
        Path clazz = Paths.get("/home/scarlxrd/documentos/estudos/OlaMundo.java");
        Path pathToClazz = dir.relativize(clazz);
        System.out.println(pathToClazz);

        Path absolute1 = Paths.get("/home/scarlxrd");
        Path absolute2 = Paths.get("/usr/local");
        Path absolute3 = Paths.get("/home/scarlxrd/documentos/estudos/OlaMundo.java");
        Path relative1 = Paths.get("/temp");
        Path relative2 = Paths.get("/temp/temp.2021921");

        System.out.println("1: " +absolute1.relativize(absolute3));
        System.out.println("2: "+absolute3.relativize(absolute1));
        System.out.println("3: "+ absolute1.relativize(absolute2));
        System.out.println("4: "+relative1.relativize(relative2));
        System.out.println("5: "+absolute1.relativize(relative1));

    }
}
