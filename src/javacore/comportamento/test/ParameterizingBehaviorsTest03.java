package javacore.comportamento.test;

import javacore.comportamento.dominio.Car;
import javacore.comportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ParameterizingBehaviorsTest03 {

    private static  List<Car> cars = List.of(new Car("green",2011), new Car("black",1998), new Car("red", 2019), new Car("blue", 2020));
    // fazendo um filter generics
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> filteredList = new ArrayList<>();
        for(T e: list){
            if (predicate.test(e)){
                filteredList.add(e);
            }
        }
        return filteredList;
    }
    public static void main(String[] args) {
        // usando lambda
        List<Car> greenCars = filter(cars, car -> car.getColor().equals("green"));
        List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));
        List<Car> yearBeforeCars = filter(cars,car -> car.getYear()<=2019);
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10,11,12);

        System.out.println("Year Before Cars: " + yearBeforeCars);
        System.out.println("Green Cars: " + greenCars);
        System.out.println("Red Cars: " + redCars);
        System.out.println("Generic filter for even numbers: "+filter(nums,num-> num%2==0));
    }
}
