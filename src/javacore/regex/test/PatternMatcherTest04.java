package javacore.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
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


        */
        
        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
        String texto = "abaaba";
        String texto2 = "12 0x 0X 0xFFABC 0X10G 0X1";
        Pattern pattern = Pattern.compile(regex);  // compila
        Matcher matcher = pattern.matcher(texto2);  // verificar se há expressao regular
        System.out.println("texto:  " + texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex: "  + regex);
        System.out.println("possicoes encontradas:  ");
        while (matcher.find()){
            System.out.print(matcher.start() + " "  + matcher.group() + "\n");
        }

        int numberHex = 0xFFFFFF;
        System.out.println(numberHex);

        /*
              obs: como no exemplo 2 ele comecar
              a verificar o valor a parti do indice 3  ele encontra o premeiro regex
              e no indece 4 aparece  o regex novamente por isso output é 0 4.


              Alguns metacaracteres

             \d = todos dígitos
             \D = tudo que não for dígitos
             \s = espaços em branco como \t \n \f \r
             \S = todos caracteres excluindo os brancos
             \w = a-ZA-Z , dígitos , _ vai retorna letras, números e underscore
             \W = o inverso do \w em minúsculo
             [] = vai buscar os caracters que estiver dentro



            no lugar de colocar hardcode as letra maiúsculas e minúsculo
            basta fazer [a-zA-Z] assim indenpende se estiver em maiusculas ou minúsculo
            ela vai conseguir retornar o valor.

         */

    }
}
