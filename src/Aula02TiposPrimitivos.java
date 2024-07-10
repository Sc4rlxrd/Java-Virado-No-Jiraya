public class Aula02TiposPrimitivos {
    public static void main(String[] args) {

        // int, double, float, char, byte, short, long, boolean
        // String é class nao um tipo primitvo

        int idade =  (int)10000000000L;  // casting -> forçar a mudança de tipo mesmo sabendo que pode haver perda de dados
        long numeroGrande = 100000;
        double salarioDouble = 2000;
        float salarioFloat = 2500;
        byte idadeByte = 19;
        short idadeShort = 19;
        boolean verdadeiro = true;
        boolean falso = false;
        char caractere = 57;   // pode usar a tabela ascii ou unicode
        System.out.println("Variável: " + idade);
        System.out.println("Variável: " + numeroGrande);
        System.out.println("caractere: " + caractere);
        System.out.println("Variável: " + idade);



    }
}
