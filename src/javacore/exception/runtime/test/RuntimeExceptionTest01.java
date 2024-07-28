package javacore.exception.runtime.test;

public class RuntimeExceptionTest01 {
    public static void main(String[] args) {
        // Checked e Unchecked
        // Checked nem deixa compilar
        // checked :  são aquelas no qual você é obrigado a tratá-la, seja com um bloco try-catch ou mesmo com um throws
        // Unchecked : não é obrigatório o tratamento da mesma, você pode tratar apenas se quiser, se sentir que é necessário para o bom funcionamento da sua aplicação.
        int [] nums = {1,2};
        System.out.println(nums[3]);

    }
}
