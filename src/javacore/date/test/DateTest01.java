package javacore.date.test;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        Date date = new Date(1724605416468L); // tipo long ele conta/armazena em milisegundos
        System.out.println("Long que representa dia de hoje: " + date.getTime());
        System.out.println(date);
    }
}
