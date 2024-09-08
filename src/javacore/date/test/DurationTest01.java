package javacore.date.test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationTest01 {
    public static void main(String[] args) {
        // Duration não tem metodo now
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2);
        LocalTime timeNow = LocalTime.now();
        LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);
        Duration d1 = Duration.between(now, nowAfterTwoYears);
        Duration d2 = Duration.between(timeNow,timeMinus7Hours);
        Duration d3 = Duration.ofDays(25); // retorna a representação em horas esses 25 dias
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

    }
}
