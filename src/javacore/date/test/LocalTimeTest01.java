package javacore.date.test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeTest01 {
    public static void main(String[] args) {
        // muito parecido com a class LocalDate em relação como funciona os metedos
        LocalTime timeAdd = LocalTime.of(23, 3,12);
        LocalTime timeNow = LocalTime.now();
        System.out.println(timeAdd);
        System.out.println(timeNow);
        System.out.println(timeAdd.getHour());
        System.out.println(timeAdd.getMinute());
        System.out.println(timeAdd.getSecond());
        System.out.println("==============================================");
        System.out.println(timeNow.getHour());
        System.out.println(timeNow.getMinute());
        System.out.println(timeNow.getSecond());
    }
}
