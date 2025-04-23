package javacore.nio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributeTest1 {
    public static void main(String[] args) throws IOException {
        // obs: DosFileAttribute foi feita para executar no windows
        Path path = Paths.get("directory2/teste.txt");
        if(Files.notExists(path)) Files.createFile(path);
        DosFileAttributes dosFileAttributes = Files.readAttributes(path,DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden()); // oculto
        System.out.println(dosFileAttributes.isReadOnly()); // somente leitura

        DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path,DosFileAttributeView.class);
        dosFileAttributeView.setHidden(true);
        dosFileAttributeView.setReadOnly(true);
        System.out.println(dosFileAttributeView.readAttributes().isHidden());
        System.out.println(dosFileAttributeView.readAttributes().isReadOnly());



    }
}
