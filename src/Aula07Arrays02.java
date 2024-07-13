public class Aula07Arrays02 {
    public static void main(String[] args) {
        // valores padrao de tipo nao inicializada
        // byte, short, int, long, float, double => 0
        // char unicode => '\u0000'
        // boolean => false
        // String, arrays => null


        String [] name = new String[4];
        name[0] = "Scarlxrd";
        name[1] = "Gon";
        name[2] = "Ichigo";
        name[3] = "Itadori";
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }
    }
}
