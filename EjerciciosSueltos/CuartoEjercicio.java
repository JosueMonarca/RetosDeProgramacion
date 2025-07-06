
/*
 * EJERCICIO:
 * - Muestra ejemplos de creación de todas las estructuras soportadas por defecto
 *   en tu lenguaje.
 * - Utiliza operaciones de inserción, borrado, actualización y ordenación.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea una agenda de contactos por terminal.
 * - Debes implementar funcionalidades de búsqueda, inserción, actualización
 *   y eliminación de contactos.
 * - Cada contacto debe tener un nombre y un número de teléfono.
 * - El programa solicita en primer lugar cuál es la operación que se quiere realizar,
 *   y a continuación los datos necesarios para llevarla a cabo.
 * - El programa no puede dejar introducir números de teléfono no numéricos y con más
 *   de 11 dígitos (o el número de dígitos que quieras).
 * - También se debe proponer una operación de finalización del programa.
 */

public class CuartoEjercicio{
    private static final java.util.HashMap<String, Integer> contacto = new java.util.HashMap<>();
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        // Ejemplo de uso de estructuras soportadas por defecto
        // Array
        int[] numeros = {1, 2, 3, 4, 5};
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // ArrayList
        java.util.ArrayList<String> lista = new java.util.ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.remove(0);
        System.out.println(lista);

        // HashMap o diccionarios 
        java.util.HashMap<String, String> mapa = new java.util.HashMap<>();
        mapa.put("clave1", "valor1");
        mapa.put("clave2", "valor2");
        mapa.remove("clave1");
        System.out.println(mapa);

        java.util.HashMap<String, Integer> ordenacion = new java.util.HashMap<>();
        ordenacion.put("clave1", 4);
        ordenacion.put("clave2", 2);
        ordenacion.put("clave3", 3);
        ordenacion.put("clave4", 1);
        
        // Ordenar el HashMap por valores
        java.util.List<java.util.Map.Entry<String, Integer>> listaOrdenada = new java.util.ArrayList<>(ordenacion.entrySet());
        System.out.println("Mapa ordenado: " + listaOrdenada);

        agenda();

    }

    private static void agenda (){
        boolean continuar = true;
        do { 
            mostrarMenu();
            int opcion = Opcion();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el nombre del contacto: ");
                    String nombre = OpcionString();
                    System.out.print("Introduce el número de teléfono: ");
                    int telefono = Opcion();

                    if(telefono < 1000000000 || telefono > 9999999999L){
                        System.out.println("Número de teléfono no válido. Debe ser numérico y tener entre 10 y 11 dígitos.");
                    } else {
                        contacto.put(nombre, telefono);
                        System.out.println("Contacto añadido: " + contacto.get(nombre));
                    }
                }
                case 2 -> {
                    System.out.println("Introdusca el nombre del contacto a buscar: ");
                    String nombre = OpcionString();
                    if(contacto.containsKey(nombre)){
                        System.out.println("Contacto encontrado :"+ contacto.get(nombre));
                    }else{
                        System.out.println("Contacto no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.println("Introdusca el nombre del contacto a actualizar:");
                    String nombre = OpcionString();

                    if(contacto.containsKey(nombre)){
                        System.out.println("Introdusca el numero a actualizar:");
                        int telefono = Opcion();

                        if(telefono < 1000000000 || telefono > 9999999999L){
                            System.out.println("Número de teléfono no válido. Debe ser numérico y tener entre 10 y 11 dígitos.");
                        } else {
                            contacto.put(nombre, telefono);
                            System.out.println("Contacto actualizado: " + contacto.get(nombre));
                        }
                    }else{
                        System.out.println("Contacto no encontrado.");
                    }
                }
                case 4 -> {
                        System.out.println("Introdusca el nombre del contacto a eliminar:");
                        String nombre = OpcionString();

                        if(contacto.containsKey(nombre)){
                            contacto.remove(nombre);
                            System.out.println("Contacto eliminado: " + nombre);
                        }
                }
                case 5 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        } while (continuar);
        System.out.println("Programa finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("1. Insertar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Actualizar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static int Opcion(){
        // Crear un objeto Scanner para leer la entrada del usuario
        try  {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            return opcion;
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("Entrada no válida. Debe ser un número.");
            return -1;
        }
    }

    private static String OpcionString(){
        // Crear un objeto Scanner para leer la entrada del usuario
        try  {
            String opcion = scanner.next();
            scanner.nextLine(); // Limpiar el buffer
            return opcion;
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("Entrada no válida. Debe ser un número.");
            return null;
        }
    }
}