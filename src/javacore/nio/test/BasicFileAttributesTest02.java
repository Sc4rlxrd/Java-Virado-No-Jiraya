package javacore.nio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {
        // windows : DosFileAttributes
        // linux and unix : PosixFileAttributes
        // BasicFileAttributes, DosFileAttributes e PosixFileAttributes: não pode modificar os arquivos
        // BasicFileAttributesView, DosFileAttributesView e PosixFileAttributesView: já pode modificar os arquivos

        Path path = Paths.get("directory2/novo.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path,BasicFileAttributes.class);
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();

        System.out.println("creationTime: " + creationTime);
        System.out.println("lastModifiedTime: " + lastModifiedTime);
        System.out.println("lastAccessTime: " + lastAccessTime);
        System.out.println("------------------------------------");

        BasicFileAttributeView fileAttributesView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());
        fileAttributesView.setTimes(lastModifiedTime,newCreationTime,creationTime);

        creationTime = fileAttributesView.readAttributes().creationTime();
        lastModifiedTime = fileAttributesView.readAttributes().lastModifiedTime();
        lastAccessTime = fileAttributesView.readAttributes().lastAccessTime();


        System.out.println("creationTime: " + creationTime);
        System.out.println("lastModifiedTime: " + lastModifiedTime);
        System.out.println("lastAccessTime: " + lastAccessTime);
    }
}
