package javacore.io.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDirectory = new File("directory");
        boolean isDirectoryCreated = fileDirectory.mkdir();
        System.out.println(STR."Pasta foi criada? \{isDirectoryCreated}");
        File directoryFile = new File(fileDirectory,"arquivo.txt");
        boolean isCreatedFile = directoryFile.createNewFile();
        System.out.println(STR."O arquivo foi criado: \{isCreatedFile}");
        File fileRenamed = new File(fileDirectory,"arquivo_renomeado.txt");
        boolean isFileRenamed = directoryFile.renameTo(fileRenamed);
        System.out.println(STR."O arquivo foi renomeado? \{isFileRenamed}");
        File directoryRenamed = new File("directory2");
        boolean isDirectoryRenamed = fileDirectory.renameTo(directoryRenamed);
        System.out.println(STR."O diretorio foi renomeado? \{isDirectoryRenamed}");


    }
}
