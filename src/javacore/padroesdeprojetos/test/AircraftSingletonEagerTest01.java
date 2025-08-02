package javacore.padroesdeprojetos.test;


import javacore.padroesdeprojetos.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat) {
        AircraftSingletonEager eager = AircraftSingletonEager.getInstance();
        System.out.println(eager.bookSeat(seat));
    }
}
