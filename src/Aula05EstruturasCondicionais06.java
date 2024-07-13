public class Aula05EstruturasCondicionais06 {
    public static void main(String[] args) {
        // dados os valores de 1 a 7, imprima se é dia útil ou final de semana
        // considerando 1 como domingo
        int dia = 1;
        switch (dia) {
            case 1:
                System.out.println("Domingo");
                System.out.println("Fim de semana");
                break;
            case 2:
                System.out.println("Segunda");
                System.out.println("Dia útil");
                break;
            case 3:
                System.out.println("Terça");
                System.out.println("Dia útil");
                break;
            case 4:
                System.out.println("Quarta");
                System.out.println("Dia útil");
                break;
            case 5:
                System.out.println("Quinta");
                System.out.println("Dia útil");
                break;
            case 6:
                System.out.println("Sexta");
                System.out.println("Dia útil");
                break;
            case 7:
                System.out.println("Sábado");
                System.out.println("Fim de semana");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
