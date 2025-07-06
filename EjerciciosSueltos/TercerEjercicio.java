
public class TercerEjercicio{
    private static final int A = 1;
    public static void main(String[] args) {
        metodoPrivado();
        System.out.println(sobrecarga(1.4, 5.9));
        System.out.println(sobrecarga(A, 5));
        System.out.println(VariableGlobalYLocal(6));
        System.out.println(A);
        System.out.println(numeroDeNumeros("a", "b"));
        System.out.println(Integer.bitCount(A));

    }

    private static void metodoPrivado() {
        System.out.println("Este es un método privado");
    }

    private static int sobrecarga(int a, int b) {
        return a + b;
    }

    private static double sobrecarga(double a, double b) {
        return a + b;
    }

    private static int VariableGlobalYLocal(int a) {
        return a;
    }

    private static int numeroDeNumeros(String a, String b){
        int suma = 0;
        
        for (int i = 0; i <=100 ; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println(a+ " " +b);
            }else if(i % 3 == 0){
                System.out.println(a);
            }else if(i % 5 == 0){
                System.out.println(b);
            }else{
                System.out.println(i);
                suma += 1;
            }

        }

        return suma;
    }
}