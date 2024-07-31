package javacore.exception.exception.test;

import javacore.exception.exception.dominio.LoginInvalidoException;

import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }

    }
    private static void logar() throws LoginInvalidoException {
        Scanner input = new Scanner(System.in);
        String userNameDb = "Scarlxrd";
        String senhaDb = "1108";
        System.out.print("Usuário: ");
        String userNameDigitado = input.nextLine();
        System.out.print("Senha: ");
        String senhaDigitada = input.nextLine();
        if(!userNameDb.equals(userNameDigitado) || !senhaDb.equals(senhaDigitada)){
            throw new LoginInvalidoException("Usuário ou senha inválidos ");
        }
        System.out.println("Login feito com sucesso...");
    }

}
