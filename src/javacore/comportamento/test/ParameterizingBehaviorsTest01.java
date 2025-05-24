package javacore.comportamento.test;

import javacore.comportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ParameterizingBehaviorsTest01 {

    private static  List<Car> cars = List.of(new Car("green",2011), new Car("black",1998), new Car("red", 2019), new Car("blue", 2020));
    private static List<Car> filterByColor(List<Car> cars, String color){
        List<Car> filterCar = new ArrayList<>();
        for (Car car: cars){
            if (car.getColor().equals(color)){
                filterCar.add(car);
            }
        }
        return filterCar;
    }
    private static List<Car> filterByYearBefore(List<Car> cars, int year){
        List<Car> filterCar = new ArrayList<>();
        for (Car car: cars){
            if (car.getYear()<=year){
                filterCar.add(car);
            }
        }
        return filterCar;
    }

    public static void main(String[] args) {
        System.out.println(filterByColor(cars,"black"));
        System.out.println(filterByColor(cars,"red"));
        System.out.println("------------ filter by year ----------------");
        System.out.println(filterByYearBefore(cars,2018));

    }
}
