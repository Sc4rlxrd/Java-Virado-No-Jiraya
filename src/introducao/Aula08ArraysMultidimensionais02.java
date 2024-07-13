package introducao;

public class Aula08ArraysMultidimensionais02 {
    public static void main(String[] args) {
        int [][] arrInt = new int[3][];

        arrInt[0] = new int[2];
        arrInt[1] = new int[]{1,2,3,};
        arrInt[2] = new int[]{1,2,3,4,5,6};

        int [][] arrayInt2 = {{0,0},{1,2,3},{1,2,3,4,5,7}};  // opcao de iniciar um array de multidimensional
        for(int[] arrBase:arrayInt2){
            System.out.println("\n======");
            for(int num:arrBase){
                System.out.print(num);
            }
        }



    }
}
