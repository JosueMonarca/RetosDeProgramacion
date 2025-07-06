
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        RegistrarEventos re = new RegistrarEventos();
        RegistrarParticipante rp = new RegistrarParticipante();
        ManejadorDeEventos mde = new ManejadorDeEventos();

        while (!salir) {
            System.out.println();
            System.out.println("=====================================================================");
            System.out.println("--------------------------------Menu---------------------------------");
            mostrarMenu();
            String opcion = scanner.nextLine();
            switch (opcion){
                case "1" ->{
                    re.addEvento(scanner);
                }
                case "2" -> {
                    rp.addParticipante(scanner);
                }
                case "3" ->{
                    simulaciónDeEventos(scanner, re, mde, rp);
                }
                case "4" ->{
                    CreadorDeInformes cr = new CreadorDeInformes(mde.getGanadores(), mde.getEvento());
                    cr.showInforme();
                    cr.showPaises();
                }
                case "5"-> {
                    System.out.println("...Saliendo del programa.....");
                    salir = true;
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }
        }
    }

    private static void mostrarMenu(){
        System.out.println("1. Registro de eventos.");
        System.out.println("2. Registro de participantes.");
        System.out.println("3. Simulación de eventos.");
        System.out.println("4. Creación de informes.");
        System.out.println("5. Salir del programa.");
    }

    private static void simulaciónDeEventos(Scanner scanner, RegistrarEventos re, ManejadorDeEventos mde, RegistrarParticipante rp){
        System.out.println("¿Qué evento desea simular? ");
        String evento = scanner.nextLine();

        System.out.println("¿Desea introducir a los participantes que competiran o competiran todos los "+
        "atletas registrados (si/no)");
        String res = scanner.nextLine();

        if(res.equalsIgnoreCase("si")){
            mde.setParticipantes(scanner);
        }

        if( re.buscarEvento(evento) != null){
            mde.setEvento(re.buscarEvento(evento));
            mde.setParticipantes(rp.getPARTICIPANTES());
            mde.crearGanadores();
        }
    }
}
