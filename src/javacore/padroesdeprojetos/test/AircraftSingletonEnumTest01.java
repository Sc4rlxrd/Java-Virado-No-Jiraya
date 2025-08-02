package javacore.padroesdeprojetos.test;

import javacore.padroesdeprojetos.dominio.AircraftSingletonEnum;

public class AircraftSingletonEnumTest01 {
    // esse jeito é mais thread safe que o double lock no último código além de não reflection para mudar o acesso do construtor
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat) {
        System.out.println(AircraftSingletonEnum.INSTANCE);
        AircraftSingletonEnum instance = AircraftSingletonEnum.INSTANCE;
        System.out.println(instance.bookSeat(seat));
    }
}
