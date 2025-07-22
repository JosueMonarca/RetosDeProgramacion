package cuadragesimo.tercer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static String directory = "C:\\repository\\c";
    public static void main(String[] args) {
        boolean noSalir = true;
        try(Scanner scanner = new Scanner(System.in)){

            while(noSalir){
                mostrarMenu();
                String comando = scanner.nextLine();
                switch (comando) {
                    case "1" -> {
                        System.out.println("Ingrese el directorio ");
                        String directorio = scanner.nextLine();
                        directory = directorio;
                    }
                    case "2" -> ejercutarComandos("git","init");
                    case "3" -> {
                        System.out.println("Ingrese el nombre de la rama");
                        String branch = scanner.nextLine();
                        ejercutarComandos("git","switch","-c", branch);
                    }
                    case "4" ->{
                        System.out.println("ingrese el nombre de la rama a la que desea saltar");
                        String branch = scanner.nextLine();
                        ejercutarComandos("git","switch",branch);
                    }
                    case "5" ->ejercutarComandos("git","status");
                    case "6" -> {
                        System.out.println("indique el mensage del commit");
                        String mensage = scanner.nextLine();
                        ejercutarComandos("git","add",".");
                        ejercutarComandos("git","commit","-m",mensage);
                    }
                    case "7" -> ejercutarComandos("git","log");
                    case "8" -> {
                        System.out.println("Ingrese el nombre de la rama a eliminar");
                        String rama = scanner.nextLine();
                        ejercutarComandos("git","branch","-d",rama);
                    }
                    case "9" ->{
                        System.out.println("Ingrese la url");
                        String url = scanner.nextLine();
                        ejercutarComandos("git","remote","add","origin",url);
                    }
                    case "10" -> ejercutarComandos("git","pull");
                    case "11" -> ejercutarComandos("git", "push", "-u", "origin", "main");
                    case "12" -> noSalir = false;
                    default -> noSalir = false;
                }
            }
            scanner.close();
        }
    }

    private static void ejercutarComandos(String... comands){
            try {
            // Directorio donde está tu repositorio
            ProcessBuilder builder = new ProcessBuilder(comands);

            // Establece el directorio de trabajo (donde se ejecutará el git add .)
            builder.directory(new java.io.File(directory));

            // Redirige la salida y errores a la consola de Java
            builder.inheritIO();

            // Ejecuta el comando
            Process process = builder.start();

            // Espera a que termine
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("comando ejecutado correctamente");
            } else {
                System.out.println("Ocurrió un error al ejecutar el comando");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMenu(){
        String menu = """
                1.Establecer el directorio de trabajo
                2.Crear un nuevo repositorio
                3.Crear una nueva rama
                4.Cambiar de rama
                5.Mostrar archivos pendientes de commit
                6.Hacer commit (incluye git add .)
                7.Mostrar historial de commits
                8.Eliminar una rama
                9.Establecer repositorio remoto
                10.Hacer git pull
                11.Hacer git push
                12.Salir del programa
                """;
                    
        System.out.println(menu);
    }
}