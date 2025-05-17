package javacore.colecoes.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        // Chaves seria um ‘set’ por esse motivo não pode ter chaves iguais e outro parâmetro seria o tipo da lista
        // precisa usar equals e hashCode por não aceitar chaves iguais.
        // .putIfAbsent() só vai add o valor caso não exista.
        // LinkedHashMap mantém a ordem de inserção dos obj.

        Map<String,String> map = new HashMap<>();
        map.put("tekado","teclado");
        map.put("mouze","mouse");
        map.put("vc","você");
        map.putIfAbsent("vc","você2");
        System.out.println(map);

        // formas de usar o ‘loop’ para acessar a lista
        for (String key: map.keySet()){
            // via chave e valor
            System.out.println(STR."Key: \{key} values: \{map.get(key)}");
        }

        System.out.println("-------------------");
        for (String value: map.values()){
            // vai mostrar somente os valores da lista
            System.out.println(value);
        }
        System.out.println("-------------------");
        for (Map.Entry<String,String> entry: map.entrySet()){
            // Esse entrySet seria um obj que tem a chave e valor da lista
            // ele faz o mesmo que a primeira forma de ‘loop’
            System.out.println(STR."Key: \{entry.getKey()}value: \{entry.getValue()}");
        }


    }
}
