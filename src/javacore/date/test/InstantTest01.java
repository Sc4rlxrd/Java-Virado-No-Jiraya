package javacore.date.test;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
    public static void main(String[] args) {
        // ela trabalha com nano segundo
        Instant now = Instant.now();
        System.out.println(now);
        System.out.print(LocalDateTime.now());
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
        System.out.println(Instant.MAX);
        System.out.println(Instant.ofEpochSecond(3,49));
        System.out.println(Instant.ofEpochMilli(200000));



    }
}
