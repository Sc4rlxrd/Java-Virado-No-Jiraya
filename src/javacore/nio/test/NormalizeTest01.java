package javacore.nio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) throws IOException {
        Path subDirectoryPath = Paths.get("home/scarlxrd/dev/java");
        Path subDirectories = Files.createDirectories(subDirectoryPath);
        Path filePath = Paths.get(subDirectoryPath.toString(), "file.txt");
        if (Files.notExists(filePath)){
            Path filePathCreated  = Files.createFile(filePath);
        }
        String textTxt = "../../file.txt";
        Path path1 = Paths.get(subDirectoryPath.toString(),textTxt);
        System.out.println(path1);
        System.out.println(path1.normalize());
    }
}
