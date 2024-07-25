package javacore.interfaces.dominio;

public class FileLoader implements DataLoader, DataRemove{
    @Override
    public void load() {
        System.out.println("Carregando arquivo");
    }

    @Override
    public void remove() {
        System.out.println("Removendo arquivo do sistema");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando no arquivo no sisteman");
    }
}
