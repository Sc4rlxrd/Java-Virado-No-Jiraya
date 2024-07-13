public class Aula08ArraysMultidimensionais01 {
    public static void main(String[] args) {

            int [][] dias = new int[3][3];
            dias[0][0] = 11;
            dias[0][1] = 10;
            dias[1][0] = 11;
            dias[1][1] = 111;

        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < dias[i].length; j++) {
                System.out.println("Arrays Multidimensionais =>" + dias[i][j]);
            }

        }

        for(int[] arrBase: dias ){
            for(int num:arrBase){
                System.out.println("Dentro do forech =>" + num);
            }
        }


    }
}
