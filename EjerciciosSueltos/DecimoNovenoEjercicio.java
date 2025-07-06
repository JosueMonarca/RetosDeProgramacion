import java.util.Scanner;
/*
 * EJERCICIO:
 * Empleando tu lenguaje, explora la definición del tipo de dato
 * que sirva para definir enumeraciones (Enum).
 * Crea un Enum que represente los días de la semana del lunes
 * al domingo, en ese orden. Con ese enumerado, crea una operación
 * que muestre el nombre del día de la semana dependiendo del número entero
 * utilizado (del 1 al 7).
 */
public class DecimoNovenoEjercicio {
    private enum DiaSemana {
        LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO;
    }

    private static String convertirNumeroADia(int numero){
        String dia = switch (numero){
            case 1 ->DiaSemana.LUNES.name();
            case 2 ->DiaSemana.MARTES.name();
            case 3 ->DiaSemana.MIERCOLES.name();
            case 4 ->DiaSemana.JUEVES.name();
            case 5 ->DiaSemana.VIERNES.name();
            case 6 ->DiaSemana.SABADO.name();
            case 7 ->DiaSemana.DOMINGO.name();
            default -> "Error - numero no válido";
        };
        return dia;
    }

    public static void main(String[] args) {
        pedido pedido1 = new pedido();
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Ingrese un número del 1 al 7 para obtener el día de la semana:");
            int numero = scanner.nextInt();
            String dia = convertirNumeroADia(numero);

            boolean error = dia.equals("Error - numero no válido");
            if (error) {
                System.out.println(dia);
            } else {
                System.out.println("El día de la semana es: " + dia);
            }

            boolean seguir =  true;

            while (seguir) {
                System.out.println("------------Menu----------");
                System.out.println("1.Cancelar pedido");
                System.out.println("2.Enviar pedido");
                System.out.println("3.Entregar pedido");
                System.out.println("4.Salir");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> pedido1.cancelarPedido();
                    case 2 -> pedido1.enviarPedido();
                    case 3 -> pedido1.entregarPedido();
                    case 4 -> seguir = false;
                    default -> System.out.println("opcion invalida");
                }
            }
        }
    }
}

