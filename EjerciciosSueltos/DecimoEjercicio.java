
import java.util.Scanner;

/*
 * EJERCICIO:
 * Explora el concepto de manejo de excepciones según tu lenguaje.
 * Fuerza un error en tu código, captura el error, imprime dicho error
 * y evita que el programa se detenga de manera inesperada.
 * Prueba a dividir "10/0" o acceder a un índice no existente
 * de un listado para intentar provocar un error.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea una función que sea capaz de procesar parámetros, pero que también
 * pueda lanzar 3 tipos diferentes de excepciones (una de ellas tiene que
 * corresponderse con un tipo de excepción creada por nosotros de manera
 * personalizada, y debe ser lanzada de manera manual) en caso de error.
 * - Captura todas las excepciones desde el lugar donde llamas a la función.
 * - Imprime el tipo de error.
 * - Imprime si no se ha producido ningún error.
 * - Imprime que la ejecución ha finalizado.
 */
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
public class DecimoEjercicio {
    
    public static void main(String[] args) {
        entradaDeUnNumero();
        segundaEntrada();
        try {
            procesarParametros(-1);
        } catch (CustomException e) {
            System.out.println("Se ha producido un error personalizado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("La ejecución ha finalizado.");
        }
        try {
            int a = 10/0;
            System.out.println("Resultado de la división: " + a);
        } catch (Exception e) {
            System.out.println("Se ha producido un error al dividir: " + e.getMessage());
        }
    }

    private static void entradaDeUnNumero(){
        try {Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce un número: ");
            int numero = scanner.nextInt();
            System.out.println("Número introducido: " + numero);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

    private static void segundaEntrada(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce un número: ");
            int numero = scanner.nextInt();
            System.out.println("Número introducido: " + numero);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } 
    }

    private static void procesarParametros(int param) throws CustomException {
        if(param < 0){
            throw new CustomException("El parámetro no puede ser negativo");
        }
        if(param == 0){
            throw new IllegalArgumentException("El parámetro no puede ser cero");
        }
        if(param > 100){
            throw new ArrayIndexOutOfBoundsException("El parámetro no puede ser mayor que 100");
        }
        System.out.println("Parámetro procesado correctamente: " + param);
    }
}

