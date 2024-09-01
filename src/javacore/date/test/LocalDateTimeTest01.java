package javacore.date.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        // ele junta todos o métodos das classes localDate e localTime em uma classes só
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate date = LocalDate.parse("2024-09-01");
        LocalTime time = LocalTime.parse("13:29:00");
        System.out.println(localDateTime);
        System.out.println(date);
        System.out.println(time);
        LocalDateTime ldt1 = date.atTime(time);
        System.out.println(ldt1);
    }
}
