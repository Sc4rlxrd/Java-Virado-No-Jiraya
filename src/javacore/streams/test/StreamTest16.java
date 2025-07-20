package javacore.streams.test;


import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
    public static void main(String[] args) {
        /*
            Alguns casos de uso e dicas para saber quando usar os parallels streams
            1- Fazer benchmark para saber se vale a pena usar parallels
            2- Cuidado com Unboxing | Boxing
            3 - Métodos como limit e findFirst são muitos ruins para usar parallels já o findAny tem usabilidade melhor
            4- Custo total da computação N(elementos) e P(processos)
            5- Quantidade de dados se for pequeno não tem necessidade de implementar parallels
            6 - Tipos de coleções como ArrayList é melhor que setList, mas sempre de uma pesquisada sobre qual usar
            7 - Tamanho da stream se tiver um tamanho pre definido melhor que uma stream que tem autoincremento
            8 - Cuidado com o processamento do merge
         */
        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 100_000_000;
        sumFor(num);
        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        sumLongStreamIterate(num);
        sumParallelLongStreamIterate(num);


    }
    private static void sumFor(long num ){
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1; i<=num; i++){
            result +=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + (end - init) +"ms");
    }
    private static void sumStreamIterate(long num){
        System.out.println("Sum Stream Iterate");
        long init =  System.currentTimeMillis();
        long result = Stream.iterate(1L,i->i).limit(num).reduce(0L,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + (end - init) +"ms");
    }
    private static void sumParallelStreamIterate(long num){
        System.out.println("Sum Parallel Stream Iterate");
        long init =  System.currentTimeMillis();
        long result = Stream.iterate(1L,i->i).limit(num).parallel().reduce(0L,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + (end - init) +"ms");
    }
    private static void sumLongStreamIterate(long num){
        System.out.println("Sum Long Stream Iterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L,num).reduce(0L,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + (end - init) +"ms");
    }
    private static void sumParallelLongStreamIterate(long num){
        System.out.println("Sum Parallel Long Stream Iterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L,num).parallel().reduce(0L,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + (end - init) +"ms");

    }


}



