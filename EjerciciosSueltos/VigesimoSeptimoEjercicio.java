/*
 * EJERCICIO:
 * Explora el "Principio SOLID Abierto-Cerrado (Open-Close Principle, OCP)"
 * y crea un ejemplo simple donde se muestre su funcionamiento
 * de forma correcta e incorrecta.
 *
 * DIFICULTAD EXTRA (opcional):
 * Desarrolla una calculadora que necesita realizar diversas operaciones matemáticas.
 * Requisitos:
 * - Debes diseñar un sistema que permita agregar nuevas operaciones utilizando el OCP.
 * Instrucciones:
 * 1. Implementa las operaciones de suma, resta, multiplicación y división.
 * 2. Comprueba que el sistema funciona.
 * 3. Agrega una quinta operación para calcular potencias.
 * 4. Comprueba que se cumple el OCP.
 */
public class VigesimoSeptimoEjercicio {
    public static void main(String[] args) {
        Calculos suma = new Suma();
        Calculos resta = new Resta();
        Calculos multiplicacion = new Multiplicacion();
        Calculos division = new Division();
        Calculos potencias = new Potencias();

        System.out.println("suma: 1 + 2 = "+suma.calcular(1, 2));
        System.out.println("resta: 5 - 3 = "+resta.calcular(5, 3));
        System.out.println("multiplicacion: 4  * 2 = "+multiplicacion.calcular(4, 2));
        System.out.println("division: 8 / 2 = "+division.calcular(8, 2));
        System.out.println("potencias: 2 ^ 3 = "+potencias.calcular(2, 3));
    }
}
