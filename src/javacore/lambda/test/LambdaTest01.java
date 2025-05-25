package javacore.lambda.test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    private static <T> void forEach(List<T> list, Consumer<T> consumer){
        for (T e: list){
            consumer.accept(e);
        }
    }
    // explicação de como funciona lambda que seria programação funcional
    // anónimas, funções, conciso
    // (parâmetro) → <expressão>
    // (Car car ) → car.getColor().equals("green");

    public static void main(String[] args) {
        List<String> strings = List.of("Rin Itoshi", "Isagi Yoichi", "Yuji Itadori", "Megumi Fushiguro");
        List<Integer> integers = List.of(1,2,4,5,6,7,8,9,10);
        forEach(strings,s -> System.out.println(s)); // esse ‘output’ depois da seta tem que ser o mesmo do mét0do testado/ criado acima
        forEach(integers,i -> System.out.println(i));
    }
}
