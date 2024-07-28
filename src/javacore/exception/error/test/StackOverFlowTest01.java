package javacore.exception.error.test;

public class StackOverFlowTest01 {
    // erro é diferente de exception
    // erro não tem como trata já o exception sim
    public static void main(String[] args) {
        recursividade();
    }
    public  static void recursividade(){
        recursividade();
    }
}
