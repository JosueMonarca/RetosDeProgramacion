/*
 * EJERCICIO:
 * Explora el concepto de clase y crea un ejemplo que implemente un inicializador,
 * atributos y una función que los imprima (teniendo en cuenta las posibilidades
 * de tu lenguaje).
 * Una vez implementada, créala, establece sus parámetros, modifícalos e imprímelos
 * utilizando su función.
 *
 * DIFICULTAD EXTRA (opcional):
 * Implementa dos clases que representen las estructuras de Pila y Cola (estudiadas
 * en el ejercicio número 7 de la ruta de estudio)
 * - Deben poder inicializarse y disponer de operaciones para añadir, eliminar,
 *   retornar el número de elementos e imprimir todo su contenido.
 */

public class OctavoEjercicio {
    public static void main(String[] args) {
        // Llamar a la función primerEjercicio para ejecutar el primer ejercicio
        primerEjercicio();
        pila();
        cola();
    }

    private static void primerEjercicio() {
        // Crear una instancia de la clase newClase con parámetros
        newClase persona = new newClase("Jane Doe", 25, "Los Angeles", "USA");

        // Imprimir los parámetros utilizando la función imprimir
        persona.imprimir();

         // Crear una instancia de la clase newClase
        newClase persona1 = new newClase();

        // Establecer los parámetros
        persona1.setName("John Doe");    
        persona1.setAge(30);
        persona1.setCity("New York");
        persona1.setCountry("USA");

        // Imprimir los parámetros utilizando la función imprimir
        persona1.imprimir();
    }

    private static void pila(){
        // se invoca a la clase Pila
        pila pila = new pila();

        // Añadir elementos a la pila
        pila.add("Elemento 1");
        pila.add("Elemento 2");
        pila.add("Elemento 3");
        // Imprimir el contenido de la pila
        pila.print();

        // Eliminar un elemento de la pila
        pila.remove();

        // Imprimir el contenido de la pila después de eliminar un elemento
        pila.print();
    }

    private static void cola(){
        // se invoca a la clase Cola
        Cola cola = new Cola();

        // Añadir elementos a la cola
        cola.add("Elemento A");
        cola.add("Elemento B");
        cola.add("Elemento C");
        // Imprimir el contenido de la cola
        cola.print();

        // Eliminar un elemento de la cola
        cola.remove();

        // Imprimir el contenido de la cola después de eliminar un elemento
        cola.print();
    }
}