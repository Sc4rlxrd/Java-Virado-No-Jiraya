package javacore.streams.test;

import java.util.List;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        integers.stream().reduce((x,y)-> x+y).ifPresent(System.out::println); // sem if_present ele retorna optional
        System.out.println(integers.stream().reduce(0,(x,y)->x+y)); // agora ele retorna um int
        // forma melhor de fazer
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println("____________________");
        integers.stream().reduce((x,y)-> x*y).ifPresent(System.out::println); // obs: tem como instanciar um valor só que precisar colocar numa variable ou no sout
        System.out.println("____________________"); // para pegar o maior valor da list
        integers.stream().reduce((x,y)->x>y?x:y).ifPresent(System.out::println); // forma feia de fazer
        System.out.println(integers.stream().reduce(0,Integer::max)); // forma bonita

    }
}
