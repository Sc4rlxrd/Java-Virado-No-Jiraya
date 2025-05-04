package javacore.nio.test;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta01");
        zip(arquivoZip, arquivosParaZipar);
    }
    private static void zip(Path arquivoZip, Path arquivosParaZipar){
        try(ZipOutputStream zipSteam = new ZipOutputStream(Files.newOutputStream(arquivoZip));
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {

            for(Path file: directoryStream){
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipSteam.putNextEntry(zipEntry);
                Files.copy(file,zipSteam);
                zipSteam.closeEntry();
            }
            System.out.println("Arquivo zipado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
