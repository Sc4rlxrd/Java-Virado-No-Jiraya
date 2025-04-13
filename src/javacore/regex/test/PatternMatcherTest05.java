package javacore.regex.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
    public static void main(String[] args) {
        /*
              Alguns metacaracteres

             \d = todos dígitos
             \D = tudo que não for dígitos
             \s = espaços em branco como \t \n \f \r
             \S = todos caracteres excluindo os brancos
             \w = a-ZA-Z , dígitos , _ vai retorna letras, números e underscore
             \W = o inverso do \w em minúsculo
             [] = vai buscar os caracters que estiver dentro como uma lista
             ? = Zero ou uma  ocorrência
             * = Zero ou mais
             + = uma ou mais
             {n,m} =  de n até m
             () = agrupamento de ocorrências
             | = o famoso OU/or
             $ = usar a ultima ocorrência/ valor
             . = coringa tudo que esta depois ponto pode ser válido ex: 1.3 output: 1.123 , 1.23 , 1.@3 etc...


        */
        
        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
      //  String texto = "abaaba";
        String texto = "luffy@hotmail.com,123jotaro@gmail.com,#@!zoro@mail.br,Teste@gmail.com.br,deku12@mail";
        Pattern pattern = Pattern.compile(regex);  // compila
        Matcher matcher = pattern.matcher(texto);  // verificar se há expressao regular
        System.out.println("texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex: "  + regex);
        System.out.println("possicoes encontradas:  ");
        while (matcher.find()){
            System.out.print(matcher.start() + " "  + matcher.group() + "\n");
        }
        System.out.println(Arrays.toString(texto.split(",")));

        /*
              obs: como no exemplo 2 ele comecar
              a verificar o valor a parti do indice 3  ele encontra o premeiro regex
              e no indece 4 aparece  o regex novamente por isso output é 0 4.



            no lugar de colocar hardcode as letra maiúsculas e minúsculo
            basta fazer [a-zA-Z] assim indenpende se estiver em maiusculas ou minúsculo
            ela vai conseguir retornar o valor.

         */

    }
}
