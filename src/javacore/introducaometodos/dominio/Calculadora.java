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
}
