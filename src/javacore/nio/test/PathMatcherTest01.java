package javacore.nio.test;

import java.nio.file.*;

public class PathMatcherTest01 {
    public static void main(String[] args) {

        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");

        matches(path1,"glob:*.bkp");
        matches(path1,"glob:**/*.bkp");  // ele procura ate dentro de pastas
        matches(path1,"glob:**/*.{bkp,txt,java}"); // procura com qualquer extensão entre chaves
        matches(path2,"glob:**/*.{bkp,txt,java}");
        matches(path3,"glob:**/*.{bkp,txt,java}");
        matches(path1,"glob:**/*.???"); // ele ignora qualquer extensão de arquivos com 3 letras
        matches(path2,"glob:**/*.???");
        matches(path3,"glob:**/*.???");  // return false porque java tem 4 letras
        matches(path3,"glob:**/file.???"); //  ele ignora qualquer extensão de arquivos
        matches(path2,"glob:**/file.???");

    }
    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(STR."\{glob}:\{matcher.matches(path)}");
    }
}
