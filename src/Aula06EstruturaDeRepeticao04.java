public class Aula06EstruturaDeRepeticao04 {
    public static void main(String[] args) {
        // dado um valor de uma carro quantas vezes pode ser parcelado
        //condição o valor da parcela>=1000;
        double valorTotal = 40000;
        for (int parcela = 1; parcela<=valorTotal; parcela++ ){
              double valorParcela = valorTotal/parcela;
            if (valorParcela >= 1000) {
                System.out.println("Parcela " + parcela + " R$:"+valorParcela);
            }else {
                break;
            }
       }
    }
}
