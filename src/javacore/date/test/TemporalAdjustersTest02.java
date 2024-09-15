package javacore.date.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;


class ObterOProximoDiaUtil implements TemporalAdjuster{

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int addDays=1;
        switch (dayOfWeek){
            case FRIDAY -> {
                addDays=3;
                break;
            }
            case SATURDAY -> {
                addDays=2;
                break;
            }
            case THURSDAY -> {
                addDays=4;
                break;
            }

        }
        return temporal.plus(addDays, ChronoUnit.DAYS);
    }
}

public class TemporalAdjustersTest02 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(new ObterOProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().withDayOfMonth(9).with(new ObterOProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());
    }
}
