package javacore.comportamento.test;

import javacore.comportamento.dominio.Car;
import javacore.comportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ParameterizingBehaviorsTest02 {

    private static  List<Car> cars = List.of(new Car("green",2011), new Car("black",1998), new Car("red", 2019), new Car("blue", 2020));

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate){
        List<Car> filterCar = new ArrayList<>();
        for (Car car: cars){
            if (carPredicate.test(car)){
                filterCar.add(car);
            }
        }
        return filterCar;
    }
    public static void main(String[] args) {
        List<Car> greenCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });

        System.out.println(greenCars);
        // usando lambdas
        List<Car> yearBeforeCars = filter(cars,car -> car.getYear()<=2019);
        System.out.println("Year Before Cars: " + yearBeforeCars);
    }
}
