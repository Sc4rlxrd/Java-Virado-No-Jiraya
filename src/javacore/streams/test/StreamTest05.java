package javacore.streams.test;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu","Gomu","No","Mi");
        String[] letters = words.get(0).split("");
        // out é a palavra Gomu do array
        System.out.println(Arrays.toString(letters));

        // out correto usando stream
        List<String> letters2 = words.stream().
                map(w -> w.split("")) // Stream<String[]>
                .flatMap(Arrays::stream) // Stream<String>
                .collect(Collectors.toList());
        System.out.println(letters2);

    }
}
