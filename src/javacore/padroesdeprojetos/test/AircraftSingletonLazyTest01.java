package javacore.padroesdeprojetos.test;

import javacore.padroesdeprojetos.dominio.AircraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AircraftSingletonLazyTest01 {
    // obs: o padrão lazy "permite" mudar o modificador de acesso do construtor mais claro não é recomendado fazer isso.
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        bookSeat("1A");
        bookSeat("1A");
        System.out.println(AircraftSingletonLazy.getInstance());
        System.out.println(AircraftSingletonLazy.getInstance());
        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AircraftSingletonLazy lazy = constructor.newInstance("787-900");
        System.out.println(lazy);

    }

    private static void bookSeat(String seat) {
        System.out.println(AircraftSingletonLazy.getInstance());
        AircraftSingletonLazy lazy = AircraftSingletonLazy.getInstance();
        System.out.println(lazy.bookSeat(seat));
    }
}
