package ejercicio.cuadragesimo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ICalendario calendario = new Calendario();
            boolean continuar = true;
            calendario.mostrarCalendario();

            while (continuar) {
                System.out.println("por favor, seleccione un día del calendario (1-24) o 0 para salir:");
                String diaSeleccionado = scanner.nextLine();

                if(diaSeleccionado.equals("0"))continuar = false;
                else if (!calendario.diaSeleccionado(Integer.parseInt(diaSeleccionado))){
                    calendario.seleccionarDia(Integer.parseInt(diaSeleccionado));
                    calendario.mostrarCalendario();
                }
                else System.out.println("Día no válido o ya seleccionado. Por favor, intente de nuevo.");
            }
            System.out.println("Gracias por usar el " + ICalendario.NOMBRE + ". ¡Feliz Navidad!");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}