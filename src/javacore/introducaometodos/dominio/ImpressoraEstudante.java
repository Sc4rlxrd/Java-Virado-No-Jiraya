package javacore.introducaometodos.dominio;

public class ImpressoraEstudante {
    public  void imprime(Estudante estudante){
        /*
        ele pode modificar o obj Estudante usado na variavel de referencia  estudante01 e estudande02 modificando o valor de referencia como exemplo o nome
         estudante.nome("gohan")
         agora todo out vai ter o nome gohan
        */

        System.out.println("Nome: " + estudante.nome);
        System.out.println("Idade: " + estudante.idade);
        System.out.println("Sexo: " + estudante.sexo);
    }
}
