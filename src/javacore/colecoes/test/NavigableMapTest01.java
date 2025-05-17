package javacore.colecoes.test;


import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {

    public static void main(String[] args) {
        // Funciona da mesma forma que NavigableSet nem incrementa nada e não tira nada da classe os mesmos métodos e forma de funcionar necessitando do compareTo.
        // obs: ele order a lista pela chave não o valor
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("E", "Letra E");

        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+" <-> " + entry.getValue());
        }

        // lower <
        // floor <=
        // higher >
        // ceiling >=
        System.out.println(map.headMap("C",true));
        System.out.println(map.ceilingKey("C"));
        System.out.println(map.higherKey("C"));
        System.out.println(map.lowerKey("C"));
        System.out.println(map.floorKey("C"));


    }
}
