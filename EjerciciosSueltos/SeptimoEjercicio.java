/*
 * EJERCICIO:
 * Implementa los mecanismos de introducción y recuperación de elementos propios de las
 * pilas (stacks - LIFO) y las colas (queue - FIFO) utilizando una estructura de array
 * o lista (dependiendo de las posibilidades de tu lenguaje).
 *
 * DIFICULTAD EXTRA (opcional):
 * - Utilizando la implementación de pila y cadenas de texto, simula el mecanismo adelante/atrás
 *   de un navegador web. Crea un programa en el que puedas navegar a una página o indicarle
 *   que te quieres desplazar adelante o atrás, mostrando en cada caso el nombre de la web.
 *   Las palabras "adelante", "atrás" desencadenan esta acción, el resto se interpreta como
 *   el nombre de una nueva web.
 * - Utilizando la implementación de cola y cadenas de texto, simula el mecanismo de una
 *   impresora compartida que recibe documentos y los imprime cuando así se le indica.
 *   La palabra "imprimir" imprime un elemento de la cola, el resto de palabras se
 *   interpretan como nombres de documentos.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SeptimoEjercicio {
    public static void main(String[] args) {
        imprimirPila();
        imprimirCola();
        // DIFICULTAD EXTRA
        try( Scanner scanner = new Scanner(System.in)) {
            // DIFICULTAD EXTRA: NAVEGADOR WEB
            dificultadExtraPila(scanner);
            // DIFICULTAD EXTRA: IMPRESORA COMPARTIDA
            dificultadExtraCola(scanner);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    private static void imprimirPila(){
        //Pila
            Stack <String> pila = new Stack<>();
            pila.push("Primer elemento");
            pila.push("Segundo elemento");
            pila.push("Tercer elemento");
            System.out.println("Pila inicial: " + pila);
            pila.pop();
            System.out.println("La lista despues de eliminar el último elemento: " + pila);
            pila.push("Cuarto elemento");
            System.out.println("La lista despues de añadir un nuevo elemento: " + pila);
            System.out.println("El primer elemento de la pila es : "+pila.peek());
            System.out.println("Para encontar un elemento en la pila, utilizaremis el método search "+
                                "que nos devuelve la posición del elemento en la pila, empezando por 1: " +
                                pila.search("Segundo elemento"));
    }

    private static void imprimirCola() {
        // Cola
        Queue<String> cola = new LinkedList<>();

        cola.add("Primer elemento");
        cola.add("Segundo elemento");
        cola.add("Tercer elemento");
        System.out.println("El metodo add añade un elemento a la cola pero si no puede manda una excepcion"+ cola);

        cola.offer("Cuarto elemento");
        cola.offer("Quinto elemento");
        cola.offer("Sexto elemento");
        System.out.println("El metodo offer añade un elemento a la cola pero si no puede manda un false"+ cola);

        cola.remove();
        System.out.println("El metodo remove elimina el primer elemento de la cola: " + cola);

        cola.poll();
        System.out.println("El metodo poll elimina el primer elemento de la cola pero si no puede " + 
                            "devuelve un null"+cola);

        String a = cola.peek();
        System.out.println("El metodo peek devuelve el primer elemento de la cola sin eliminarlo: " + a);
        System.out.println("El metodo element devuelve el primer elemento de la cola sin eliminarlo: " + cola.element());
    }

    private static void dificultadExtraPila(Scanner scanner){
        // DIFICULTAD EXTRA: NAVEGADOR WEB
        // Simulación de un navegador web con una pila
        // Utilizaremos una pila para almacenar las páginas visitadas

        Stack <String> navegador = new Stack<>();
        boolean seguir = true; 
        int posicionaActual = 0; // Variable para llevar la cuenta de la posición actual en la pila
        System.out.println("Navegador web simulado. Escribe una paguina para buscar, 'adelante' para avanzar, 'atrás' para retroceder.");
        System.out.println("Ingrese la primer paguina a visitar por favor:");
        String entrada = scanner.nextLine(); // Leer la primera página visitada
        navegador.push(entrada); // Añadir la primera página a la pila
        
        while (seguir){
            System.out.println("Ingrese una nueva paguina a añadir, o 'adelante' para avanzar, 'atras' para retroceder, 'imprimir' para saber donde esta parado o 'salir' para terminar: ");
            entrada = scanner.nextLine();
            if(entrada.equalsIgnoreCase("adelante") && posicionaActual < navegador.size() -1 ){
                posicionaActual++;
                System.out.println("Avanzando a la página: " + navegador.get(posicionaActual));
            }
            else if(entrada.equalsIgnoreCase("atras") && posicionaActual > 0){
                posicionaActual --;
                System.out.println("Retrocediendo a la página: "+ navegador.get(posicionaActual));
            }
            else if (entrada.equalsIgnoreCase("imprimir") && !navegador.isEmpty()){
                System.out.println("Actualmente esta parado en: "+ navegador.get(posicionaActual));
            }
            else if( entrada.equalsIgnoreCase("salir")){
                System.out.println("Gracias por usar el navegador !Hasta luego!");
                seguir = false; // Terminar el bucle
            }
            else if (!entrada.equalsIgnoreCase("salir") &&
                    !entrada.equalsIgnoreCase("adelante") &&
                    !entrada.equalsIgnoreCase("atras") &&
                    !entrada.equalsIgnoreCase("imprimir")) {
                // Si la entrada no es un comando especial, se interpreta como una nueva página
                navegador.push(entrada);
                posicionaActual = navegador.size() - 1; // Actualizar la posición actual al final de la pila
                System.out.println("Nueva página añadida: " + entrada);
            } else {
                System.out.println("Comando no reconocido o no se puede avanzar/retroceder más.");
                
            }
        }
    }

    private static void dificultadExtraCola(Scanner scanner){
        // DIFICULTAD EXTRA: IMPRESORA COMPARTIDA
        // Simulación de una impresora compartida con una cola
        Queue<String> impresora = new LinkedList<>();

        boolean seguir = true;
        System.out.println("¡BIENVENIDA A LA IMPRESORA COMPARTIDA!");
        System.out.println("Escriba el nombre del documento que desea imprimir o utilize"+
                        " la palabra 'imprimir' para imprimir el siguiente documento en la cola "+
                        " o la palabra 'salir' para terminar el programa.");
        String entrada = scanner.nextLine(); // Leer la entrada del usuario
        while(seguir){
            if(entrada.equalsIgnoreCase("imprimir")){
                if(impresora.isEmpty()){
                    System.out.println("No hay documentos en la cola para imprimir");
                }else{
                    String documentoImpreso = impresora.poll(); // Imprimir el siguiente documento
                    System.out.println("Imprimiendo documento: " + documentoImpreso);
                }
            }else{
                boolean noFallo = impresora.offer(entrada); // Añadir un nuevo documento a la cola
                if(noFallo){
                    System.out.println("Documento añadido a la cola: " + entrada);
                } else {
                    System.out.println("No se pudo añadir el documento a la cola, la cola está llena.");
                }
            }
            if (entrada.equalsIgnoreCase("salir")){
                System.out.println("GRACIAS POR UTILIZAR LA IMPRESORA COMPARTIDA! HASTA LUEGO!");
                seguir = false; // Terminar el bucle
            }
            else {
                System.out.print("Escriba el nombre del siguiente documento que desea imprimir o "+
                                "utilice la palabra 'imprimir' para imprimir el siguiente documento en la cola "+
                                "o la palabra 'salir' para terminar el programa: ");
                entrada = scanner.nextLine(); // Leer la siguiente entrada del usuario
            }
        }
        
    }
}