public class Aula07Arrays03 {
    public static void main(String[] args) {
        int [] numeros = new int[3]; // forma 01
        int [] numeros2 = {1,2,3,4,5}; // forma 02
        int [] numeros3 = new int []{1,2,3,4,5}; // forma 03

        // foreach tem que ser o mesmo tipo do array
        for(int num:numeros3){
            System.out.println("Dentro do foreach: "  + num);
        }
        //Padrao
        for (int i = 0; i < numeros2.length; i++) {
            System.out.println("Dentro do for: " + numeros2[i]);
        }

        String [] name = {"Scarlxrd","Itadori", "Goku", "Meliodas","Gon","Killua"};
        for (String name2:name){
            System.out.println("Um foreach de String => "+ name2);
        }


    }
}
