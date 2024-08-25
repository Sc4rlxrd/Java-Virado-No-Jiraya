package javacore.formatacao.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {
    public static void main(String[] args) {
        Locale localeBr = Locale.getDefault();
        Locale localeItaly = new Locale("it","IT");
        Locale localeBrSemDefault = new Locale("pt-BR","BR");
        Locale localeCH= new Locale("it","CH");
        Calendar  calendar = Calendar.getInstance();
        DateFormat df1 =  DateFormat.getDateInstance(DateFormat.FULL,localeBr);
        DateFormat df2 =  DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df3 =  DateFormat.getDateInstance(DateFormat.FULL, localeCH);
        DateFormat df4 =  DateFormat.getDateInstance(DateFormat.FULL, localeBrSemDefault);
        System.out.println("BRASIL: " + df1.format(calendar.getTime()));
        System.out.println("Itália: " + df2.format(calendar.getTime()));
        System.out.println("Suiça: " + df3.format(calendar.getTime()));
        System.out.println("Brasil sem default: " + df4.format(calendar.getTime()));
    }
}
