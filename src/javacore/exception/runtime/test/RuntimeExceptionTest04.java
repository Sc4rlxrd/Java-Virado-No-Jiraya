package javacore.exception.runtime.test;

public class RuntimeExceptionTest04 {
    public static void main(String[] args) {
        // exceptions mais genéricas sempre vai ser o último catch possível senão o catch mais específico nao vai funcionar
        try {
//            throw new IllegalArgumentException();
//            throw new ArithmeticException();
//           throw new ArrayIndexOutOfBoundsException();
//           throw new IndexOutOfBoundsException();
            throw new RuntimeException();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception: " + e);
        }catch (IllegalArgumentException e){
            System.out.println("Exception: " + e);
        }catch (ArithmeticException e){
            System.out.println("Exception: " + e);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Exception: " + e);
        }catch (RuntimeException e){
            System.out.println("Exception: " + e);
        }
    }
}
