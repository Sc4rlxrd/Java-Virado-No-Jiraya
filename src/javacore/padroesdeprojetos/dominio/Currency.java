package javacore.padroesdeprojetos.dominio;

public interface Currency {
    String getSymbol();
}
class Real implements Currency{
    @Override
    public String getSymbol() {
        return "R$ ";
    }
}
class UsaDollar implements Currency{
    @Override
    public String getSymbol() {
        return "$ ";
    }
}
