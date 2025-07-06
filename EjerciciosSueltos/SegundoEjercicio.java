public class SegundoEjercicio {
    public static void main(String[] args) {
        int suma = 1+2;
        suma++;
        suma +=2;
        suma --;
        suma -=1;
        suma *=4;
        suma /=2;
        suma %=3;


        double division = 5.0/2.0;
        double division2 = 5%2;

        String nombre = "Juan";
        String apellido = "Pérez";
        String nombreCompleto = nombre + " " + apellido;

        boolean esMenor = 5 < 2;
        boolean esIgual = 5 == 2;
        boolean esMayorIgual = 5 >= 2;
        boolean esMenorIgual = 5 <= 2;

        boolean algebraBooleana = true && (false ||true) && false || (true);

        boolean esMayor = true;
        System.out.println(esMayor);

        if(algebraBooleana){
            System.out.println("Es verdadero");
        }
        else{
            System.out.println("Es falso");
        }

        switch (suma) {
            case 1 -> System.out.println("Suma es 1");
            case 2 -> System.out.println("Suma es 2");
            case 3 -> System.out.println("Suma es 3");
            default -> System.out.println("Suma no es 1, 2 o 3");
        }

        for(int i = 0; i < suma; i++){
            System.out.println("i es: " + i);
        }

        while (esIgual){
            System.out.println("Es igual");
            esIgual = false;
        }

        do { 
            System.err.println("Es mayor");
            esMayor = false;
        } while (esMayor);

        System.out.println("Suma: " + suma);
        System.out.println("Division: " + division);
        System.out.println("Para que deje de chillar:" + division2 + division+ nombreCompleto+esMenor+esIgual+esMayorIgual+esMenorIgual+algebraBooleana);

        try {
            int[] arreglo = new int[5];
            arreglo[0] = 1;
            arreglo[5] = 2;
            System.out.println(arreglo[5]);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        for(int i = 10; i <= 55 ; i++){
            if(i != 16 && i % 3 != 0){
                System.err.println(i);
            }
        }
    }
}
