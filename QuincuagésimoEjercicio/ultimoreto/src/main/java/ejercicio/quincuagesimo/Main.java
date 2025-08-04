package ejercicio.quincuagesimo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<IObjetivo> OBJETIVOS = new ArrayList<>();
    private final int NUMMESES = 12;
    private final String[] MESES = {"Enero",
    "Febrero", "Marzo", "Abril", "Mayo", "Junio",
    "Julio", "Agosto", "Septiembre", "Octubre", 
    "Noviembre", "Diciembre"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        Main mainInstance = new Main();

        while (continuar) {
            System.out.println("1. Añadir objetivos");
            System.out.println("2. ver informe");
            System.out.println("3. Generar informe .txt");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    Objetivo objetivo = mainInstance.crearObjetivo(scanner);
                    OBJETIVOS.add(objetivo);
                    System.out.println("Objetivo añadido: " + objetivo.obtenerObjetivo());
                }
                case "2" -> {
                    String informe = mainInstance.generarInforme();
                    if (informe.isEmpty()) {
                        System.out.println("No hay objetivos para mostrar.");
                    } else {
                        System.out.println("Informe de objetivos:");
                        System.out.println(informe);
                    }
                }
                case "3" -> {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("informe.txt"))) {
                        writer.write(mainInstance.generarInforme());  // Asume que este método devuelve un String
                        System.out.println("Informe generado en informe.txt");
                    } catch (IOException e) {
                        System.out.println("Error al escribir el informe: " + e.getMessage());
                    }
                }
                case "4" -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
        
    }

    private String generarInforme() {
        StringBuilder informe = new StringBuilder();

        for (int i = 0; i < NUMMESES; i++) {
            boolean mesTieneObjetivos = false;
            StringBuilder contenidoMes = new StringBuilder();

            for (IObjetivo objetivo : OBJETIVOS) {
                if (i + 1 <= objetivo.obtenerPlazo()) {
                    mesTieneObjetivos = true;
                    contenidoMes.append("  [ ] ")
                        .append(objetivo.obtenerObjetivo())
                        .append(" (")
                        .append(objetivo.cantidadSobrePlazo())
                        .append(" ")
                        .append(objetivo.obtenerUnidad())
                        .append("/mes)")
                        .append(" | Prioridad: ")
                        .append(objetivo.obtenerPrioridad())
                        .append(" | Plazo total: ")
                        .append(objetivo.obtenerPlazo())
                        .append(" meses")
                        .append("\n");
                }
            }

            if (mesTieneObjetivos) {
                informe.append(MESES[i]).append(":\n");
                informe.append(contenidoMes).append("\n");
            }
        }

        return informe.toString();
    }
    
    private Objetivo crearObjetivo(Scanner scanner) {
        Objetivo objetivo = new Objetivo();
        
        System.out.print("Introduce el objetivo: ");
        objetivo.anadirObjetivo(scanner.nextLine());
        
        // Cantidad
        System.out.print("Introduce la cantidad: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Error. La cantidad debe ser un número entero. Intenta de nuevo: ");
            scanner.next(); // limpiar entrada inválida
        }
        objetivo.anadirCantidad(scanner.nextInt());
        scanner.nextLine(); // limpiar el salto de línea
    
        // Unidad
        System.out.print("Introduce la unidad: ");
        String unidad = scanner.nextLine().trim();
        while (unidad.isEmpty()) {
            System.out.print("Unidad no puede estar vacía. Intenta de nuevo: ");
            unidad = scanner.nextLine().trim();
        }
        objetivo.anadirUnidad(unidad);
    
        // Plazo
        int plazo;
        while (true) {
            System.out.print("Introduce el plazo (en meses, entre 1 y 12): ");
            if (scanner.hasNextInt()) {
                plazo = scanner.nextInt();
                if (plazo >= 1 && plazo <= 12) break;
            } else {
                scanner.next(); // limpiar entrada inválida
            }
            System.out.println("Plazo inválido. Debe ser un número entre 1 y 12.");
        }
        objetivo.establecerPlazo(plazo);
    
        // Prioridad
        int prioridad;
        while (true) {
            System.out.print("Introduce la prioridad (1-10): ");
            if (scanner.hasNextInt()) {
                prioridad = scanner.nextInt();
                if (prioridad >= 1 && prioridad <= 10) break;
            } else {
                scanner.next(); // limpiar entrada inválida
            }
            System.out.println("Prioridad inválida. Debe ser un número entre 1 y 10.");
        }
        objetivo.establecerPrioridad(prioridad);
    
        return objetivo;
    }   
}