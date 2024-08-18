package javacore.strings.test;

public class StringPerformanceTest01 {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatString(200_000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para String: " + (fim-inicio) + "ms");

         inicio = System.currentTimeMillis();
        concatStringBuilder(200_000);
         fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuilder: " + (fim-inicio) + "ms");


        inicio = System.currentTimeMillis();
        concatStringBuffer(200_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuffer: " + (fim-inicio) + "ms");

    }

    private  static  void concatString(int tamanho){
        String texto = "";
        for (int i = 0; i<tamanho; i++){
            texto+=i; // 0,01,012,0123.....
        }
    }
    private  static  void concatStringBuilder(int tamanho){
       StringBuilder sb = new StringBuilder();
        for (int i = 0; i<tamanho; i++){
            sb.append(i);
        }
    }
    private  static  void concatStringBuffer(int tamanho){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<tamanho; i++){
            sb.append(i);
        }
    }

}
