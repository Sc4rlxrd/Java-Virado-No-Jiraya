package javacore.introducaometodos.dominio;

public class Calculadora {

    public  void somaDoisNumeros(){
        System.out.println(10+10);
        System.out.println("Finalizando.... ");
    }
    public  void subtraiDoisNumeros(){
        System.out.println(22-2);
        System.out.println("Finalizando a conta de menos");
    }

    // pode passar qualquer tipo de parametros, tipo primitivo e tipo referencia como String e arrays
    public void multiplicaDoisNumeros(int num1, int num2){
        System.out.println(num1*num2);

    }
    public double divideDoisNumeros(double num1, double num2){
        if (num2 ==0){
            return 0;
        }
        return num1/num2;
    }

    public double divideDoisNumeros2(double num1, double num2){
        if(num2!=0){
            return num1/num2;
        }
        System.out.println("Não existe divisão por zero");
        return 0;
    }
    public void imprimeDivisaoDeDoisNumeros(double num1, double num2){
        if(num2 ==0){
            System.out.println("Não existe divisão por zero");
        }else{
            System.out.println(num1/num2);
        }

    }

    public void alteraDoisNumeros(int num1, int num2){
        num1=99;
        num2=33;
        System.out.println("Dentro do AlteraDoisNumeros");
        System.out.println("num1 " + num1);
        System.out.println("num2 " + num2);
    }

    public void somaArray(int[] numeros ){
        int soma = 0;
        for(int temp: numeros){
            soma+=temp;
        }
        System.out.println(soma);
    }
    /*
            Nao pode ter outro parametro depois o varArgs
            o jeito de iniciar um varArgs so tem esse  jeito
            pode usar o VarArgs assim tambem mas o primeiro valor vai ser alocado na primeiro parametro como no exemplo v1

            public void somarVarArgs( double v1 , int... numeros){}
     */
    public void somarVarArgs(int... numeros){
        int soma = 0;
        for(int temp:numeros){
            soma+=temp;
        }
        System.out.println(soma);
    }



}
