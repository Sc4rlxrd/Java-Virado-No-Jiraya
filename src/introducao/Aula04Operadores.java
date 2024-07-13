package introducao;

public class Aula04Operadores {
    public static void main(String[] args) {

        // Aritimeticos -> + - * /

        int valor1=10;
        int valor2 = 20;
        double resultado = valor1 + valor2;
        System.out.println("O resultado: " + resultado );

        // %
        int resto = 20%2;
        System.out.println(resto);

        // < > <= >= == !=
        boolean isDezMaiorQueVinte = 10>20;
        boolean isDezMenorQueVinte = 10<20;
        boolean isDezIgualADez = 10==10;
        boolean isDezIgualVinte = 10==20;
        boolean isDezDiferenteDez = 10!=10;
        System.out.println("isDezMaiorQueVinte " + isDezMaiorQueVinte);
        System.out.println("isDezMenorQueVinte " + isDezMenorQueVinte);
        System.out.println("isDezIgualADez " +isDezIgualADez);
        System.out.println("isDezDiferenteDez " + isDezDiferenteDez);
        System.out.println("isDezIgualVinte " + isDezIgualVinte);


        // lógicos
        // && -> AND   || -> OR  ! -> negação

        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade>=30 && salario>=4612;
        boolean isDentroDaLeiMenorQueTrinta = idade<30 && salario>=3381;
        System.out.println("isDentroDaLeiMaiorQueTrinta: "  + isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta: "  + isDentroDaLeiMenorQueTrinta);

        double valorTotalContaCorrente = 200;
        double valorTotalPoupanca = 10000;
        float valorPlaystation = 5000F;
        boolean isPlaystationCincoCompravevel = valorTotalContaCorrente > valorPlaystation || valorTotalPoupanca > valorPlaystation;

        System.out.println("isPlaystationCincoCompravevel: " + isPlaystationCincoCompravevel);

        // atribuição
        // = += -= *= /= %=

        double bonus = 1800;
        bonus += 1000; //2800
        bonus -= 1000; // 1800
        bonus *=2;
        bonus /=2;
        bonus %=2;
        System.out.println("Bonus: " + bonus);

        // unarios
        // ++ -> adicioanando   -- -> removendo

        int contador = 0;
        contador ++;
        contador --;
        contador ++;
        System.out.println("Contador:" + contador);

        int contador2 =0;
        System.out.println(contador2++);  // -> mostra o print depois add
        System.out.println(++contador2); // -> primeiro add depois o print





    }
}
