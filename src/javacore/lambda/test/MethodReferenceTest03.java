package javacore.lambda.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

// Reference to an instance method of an arbitrary object of a particular type

public class MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Rimuru","Veldora","Naruto","Isagi"));
        list.sort(String::compareTo);
        System.out.println(list);

        // numa função
        Function<String,Integer> numStringToInteger = Integer::parseInt;
        Integer num = numStringToInteger.apply("10");
        System.out.println(numStringToInteger.apply("11082004"));
        System.out.println(num);

        // usando numa lista para procura um nome/‘item’
        BiPredicate<List<String>,String> checkName = List::contains;
        System.out.println(checkName.test(list,"Isagi"));

    }
}
