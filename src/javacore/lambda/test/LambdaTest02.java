package javacore.lambda.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    // t -> tipo
    // r -> retorno
    private static <T,R>List<R> map(List<T> list, Function<T,R> function){
        List<R> result = new ArrayList<>();
        for(T t:list){
            R r = function.apply(t);
            result.add(r);
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> strings = List.of("Natsu", "Allucard","Rin Itoshi", "Isagi Yoichi", "Yuji Itadori", "Megumi Fushiguro");
        List<Integer> stringLength = map(strings, s -> s.length());
        List<String> stringsToUpperCase = map(strings, s -> s.toUpperCase());
        List<String> strinsToLowerCase = map(strings, s -> s.toLowerCase());
        System.out.println("A lista pura: " + strings);
        System.out.println("Quantidade de letras em cada nome da lista: " + stringLength);
        System.out.println("Valores da lista toda em Caps-Lock: " + stringsToUpperCase);
        System.out.println("Valores da lista toda em minúsculo: " + strinsToLowerCase);


    }
}
