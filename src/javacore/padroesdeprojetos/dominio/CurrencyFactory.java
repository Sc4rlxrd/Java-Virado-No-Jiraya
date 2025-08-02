package javacore.padroesdeprojetos.dominio;

public class CurrencyFactory {
    public static Currency newCurrency(Country country){
        switch (country){
            case USA -> {
                return new UsaDollar();
            }
            case BRAZIL -> {
                return new Real();
            }
            default -> throw new IllegalArgumentException("No Currency found for this country");
        }
    }
}
