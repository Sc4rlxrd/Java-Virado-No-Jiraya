package javacore.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {
        /*
            Alguns metacaracteres

             \d = todos dígitos
             \D = tudo que não for dígitos
             \s = espaços em branco como \t \n \f \r
             \S = todos caracteres excluindo os brancos
             \w = a-ZA-Z , dígitos , _ vai retorna letras, números e underscore
             \W = o inverso do \w em minúsculo

         */
        
        String regex = "\\w";
        String texto = "abaaba";
        String texto2 = "@#rkso3 151dq";
        Pattern pattern = Pattern.compile(regex);  // compila
        Matcher matcher = pattern.matcher(texto2);  // verificar se há expressao regular
        System.out.println("texto:  " + texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex: "  + regex);
        System.out.println("possicoes encontradas:  ");
        while (matcher.find()){
            System.out.print(matcher.start() + " "  + matcher.group() + "\n");
        }

        /*
              obs: como no exemplo 2 ele comecar
              a verificar o valor a parti do indice 3  ele encontra o premeiro regex
              e no indece 4 aparece  o regex novamente por isso output é 0 4.
        */

    }
}
