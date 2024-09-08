package javacore.date.test;


import java.time.LocalDate;
import java.time.Period;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(3);
        Period p1 = Period.between(now,nowAfterTwoYears);
        Period days = Period.ofDays(10);
        Period ofWeeks = Period.ofWeeks(60);
        Period ofMonths = Period.ofMonths(3);
        Period ofYears = Period.ofYears(3);
        System.out.println(p1);
        System.out.println(days);
        System.out.println(ofWeeks);
        System.out.println(ofMonths);
        System.out.println(ofYears);
    }
}
