package javacore.nio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        // windows : DosFileAttributes
        // linux and unix : PosixFileAttributes

        //  METODO ANTIGO
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        File file = new File("directory2/novo.txt");
        boolean isCreated = file.createNewFile();
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        // METODO NOVO
        Path path = Paths.get("directory2/novo_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path,fileTime);
        System.out.println("isWritable:" + Files.isWritable(path));
        System.out.println("isReadable:" + Files.isReadable(path));
        System.out.println("isExecutable: " + Files.isExecutable(path));

    }
}
