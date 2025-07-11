/*
 * EJERCICIO:
 * Explora el "Principio SOLID de Sustitución de Liskov (Liskov Substitution Principle, LSP)"
 * y crea un ejemplo simple donde se muestre su funcionamiento
 * de forma correcta e incorrecta.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea una jerarquía de vehículos. Todos ellos deben poder acelerar y frenar, así como
 * cumplir el LSP.
 * Instrucciones:
 * 1. Crea la clase Vehículo.
 * 2. Añade tres subclases de Vehículo.
 * 3. Implementa las operaciones "acelerar" y "frenar" como corresponda.
 * 4. Desarrolla un código que compruebe que se cumple el LSP.
 */
public class VigesimoOctavoEjercicio {
    public static void main(String[] args) {
        Vehiculo ve = new Vehiculo("V", "V");
        Carro ca = new Carro("C", "C", "Toyota", "Corolla", 2020);

        if (ca.equals(ve)){
            System.out.println("El carro es un vehículo válido.");
        } else {
            System.out.println("El carro no es un vehículo válido.");
        }
    }
}
