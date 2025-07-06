/*
 * EJERCICIO:
 * Entiende el concepto de recursividad creando una función recursiva que imprima
 * números del 100 al 0.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utiliza el concepto de recursividad para:
 * - Calcular el factorial de un número concreto (la función recibe ese número).
 * - Calcular el valor de un elemento concreto (según su posición) en la 
 *   sucesión de Fibonacci (la función recibe la posición).
 */
public class SextoEjercicio {
    public static void main(String[] args) {
        recursividad100to0(100);
        System.out.println("Factorial de 5: " + factorial(5));
        System.out.println("Fibonacci en la posición 6: " + Fibonacci(6));
    }

    private static int recursividad100to0(int n){
        if(n > 0){
            System.out.println(n);
            return recursividad100to0( n - 1);
        }else{
            System.out.println(n);
            return n;
        }
    }

    private static int factorial(int n){
        if(n > 0){
            return n * factorial(n - 1);
        }else{
            return 1; // El factorial de 0 es 1
        }
    }

    private static int Fibonacci (int n){
        if(n > 1){
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        } else if (n == 1 || n == 0) {
            return n; // Fibonacci(0) = 0, Fibonacci(1) = 1
        } else {
            throw new IllegalArgumentException("La posición debe ser un número entero no negativo.");
        }
    }
}
