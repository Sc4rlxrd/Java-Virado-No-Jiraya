package javacore.comportamento.interfaces;

import javacore.comportamento.dominio.Car;

public interface CarPredicate {
    boolean test(Car car);
}
