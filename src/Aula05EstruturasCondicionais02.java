public class Aula05EstruturasCondicionais02 {
    // idade < 15 categoria infantil
    // idade >= 15 && idade <=18 categoria juvenil
    // idade >= 18 categoria juvenil
    public static void main(String[] args) {
        int idade = 15;
        if(idade <15){
            System.out.println("Jogador da categoria infantil");
        } else if (idade>=15 && idade <=18) {
            System.out.println("Jogador da categoria juvenil");
        }else {
            System.out.println("Jogador da categoria adulto");

        }
    }

}
