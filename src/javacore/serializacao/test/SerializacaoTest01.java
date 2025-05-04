package javacore.serializacao.test;

import javacore.serializacao.dominio.Aluno;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(1L,"Scarlxrd","123459876");
       serializar(aluno);
       deserializar(); // a deserlização não acessa o construtor
    }

    private static void serializar(Aluno aluno){
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectOutputStream oss = new ObjectOutputStream(Files.newOutputStream(path))) {
            oss.writeObject(aluno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void deserializar(){
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println("Aluno: " + aluno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
