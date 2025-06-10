package javacore.optional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Scarlxrd");
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);

        System.out.println("________________");

        Optional<String> nameOptional = Optional.ofNullable(findName("Ichigo"));
        String empty = nameOptional.orElse("EMPTY");
        System.out.println(empty);
        nameOptional.ifPresent(s-> System.out.println(s.toUpperCase()));

    }

    private static String findName(String name){
        List<String> list = List.of("Isagi", "Naruto", "Ichigo");
        int i = list.indexOf(name);
        if (i != 1){
            return list.get(i);
        }
        return null;
    }
}
