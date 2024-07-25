package javacore.interfaces.dominio;

public class DatabaseLoader  implements  DataLoader, DataRemove{
    @Override
    public void remove() {
        System.out.println("Removendo dados do banco de dados");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando no banco de dados");
    }

    @Override
    public void load() {
        System.out.println("Carregando dados do banco de dados");
    }
}
