package javacore.padroesdeprojetos.test;

import javacore.padroesdeprojetos.dominio.Country;
import javacore.padroesdeprojetos.dominio.Currency;
import javacore.padroesdeprojetos.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println("BRAZIL: "+currency.getSymbol());
        Currency currency1 = CurrencyFactory.newCurrency(Country.USA);
        System.out.println("USA: "+currency1.getSymbol());
    }
}
