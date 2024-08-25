package javacore.date.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        // ela uma class abstract
        Calendar calendar = Calendar.getInstance();
       // System.out.println(calendar);


        if(calendar.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Domingo primeiro dia da semana");
        }
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

        calendar.add(Calendar.DAY_OF_MONTH,2);
        calendar.add(Calendar.HOUR,2);
        Date date = calendar.getTime();
        System.out.println(date);

    }
}
