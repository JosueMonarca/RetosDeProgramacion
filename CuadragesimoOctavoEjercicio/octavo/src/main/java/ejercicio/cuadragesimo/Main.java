package ejercicio.cuadragesimo;

import java.util.Scanner;

public class Main {
    private static IArbolNavidad arbol = new ArbolNavidad(7);
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido al programa de gestión del árbol de Navidad.");
            boolean continuar = true;

            while (continuar) {
                mostrarMenu();
                String opcion = scanner.nextLine();
                switch (opcion) {
                    case "1" -> arbol.mostrarArbol();
                    case "2" -> mostrarResultado("Agregar luces", arbol.agregarLuces());
                    case "3" -> mostrarResultado("Eliminar luces", arbol.eliminarLuces());
                    case "4" -> mostrarResultado("Encender luces", arbol.encenderLuces(true));
                    case "5" -> mostrarResultado("Mostrar estrella", arbol.mostrarEstrella(true));
                    case "6" -> mostrarResultado("Agregar esferas", arbol.agregarEsferas());
                    case "7" -> mostrarResultado("Eliminar esferas", arbol.eliminarEsferas());
                    case "8" -> {
                        System.out.print("Nueva altura (impar > 5): ");
                        int altura = scanner.nextInt();
                        scanner.nextLine();
                        if (arbol.cambiarAltura(altura)) {
                            arbol = new ArbolNavidad(altura);
                            System.out.println("Altura cambiada correctamente.");
                        } else {
                            System.out.println("Altura inválida.");
                        }
                    }
                    case "9" -> continuar = false;
                    default -> System.out.println("Opción inválida.");
                }
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Mostrar árbol
                2. Agregar luces
                3. Eliminar luces
                4. Encender luces
                5. Mostrar estrella
                6. Agregar esferas
                7. Eliminar esferas
                8. Cambiar altura del árbol
                9. Salir
                Elige una opción:
                """);
    }

    private static void mostrarResultado(String accion, boolean resultado) {
        System.out.println(resultado ? accion + " realizada con éxito." : accion + " no se pudo realizar.");
    }
}