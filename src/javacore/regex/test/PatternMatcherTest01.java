package javacore.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
    public static void main(String[] args) {
        /*
          obs: como no exemplo 2 ele comecar
          a verificar o valor a parti do indice 3  ele encontra o premeiro regex
          e no indece 4 aparece  o regex novamente por isso output é 0 4.
        */

        //  expressão regular

        String regex = "aba";
        String texto = "abaaba";
        String texto2 = "abababa";
        Pattern pattern = Pattern.compile(regex);  // compila
        Matcher matcher = pattern.matcher(texto2);  // verificar se há expressao regular
        System.out.println("texto:  " + texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex: "  + regex);
        System.out.println("possicoes encontradas:  ");
        while (matcher.find()){
            System.out.print(matcher.start() + " ");
        }

    }
}
