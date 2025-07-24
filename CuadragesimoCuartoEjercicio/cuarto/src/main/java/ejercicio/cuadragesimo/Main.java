package ejercicio.cuadragesimo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el año ");
            String ano = scanner.nextLine();
            System.out.println("ingrese el mes");
            String mes = scanner.nextLine();
            System.out.println("Ingrese el dia");
            String dia = scanner.nextLine();
            System.out.println("Ingrese la hora");
            String hora = scanner.nextLine();
            System.out.println("Ingrese el minuto");
            String minuto = scanner.nextLine();

            String fecha = dia+"-"+mes+"-"+ano+" "+hora+":"+minuto+":00";

            DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime fechaLocal = LocalDateTime.parse(fecha, dateFormater);

            ZoneId zonaLocal = ZoneId.systemDefault();
            ZonedDateTime fechaZonificada = fechaLocal.atZone(zonaLocal);

            ZonedDateTime fechaUTC = fechaZonificada.withZoneSameInstant(ZoneOffset.UTC);

            Thread cuentaAtras = new Thread(() -> {
                while (true) {
                    ZonedDateTime ahora = ZonedDateTime.now(ZoneOffset.UTC);
                    Duration duracion = Duration.between(ahora, fechaUTC);

                    if (!duracion.isNegative()) {
                        long segundosTotales = duracion.getSeconds();

                        long dias = segundosTotales / 86400;
                        long horas = (segundosTotales % 86400) / 3600;
                        long minutos = (segundosTotales % 3600) / 60;
                        long segundos = segundosTotales % 60;

                        // Limpiar consola
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.printf("Faltan %d días, %02d:%02d:%02d\n", dias, horas, minutos, segundos);
                        
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            break;
                        }

                    } else {
                        System.out.println("¡La cuenta regresiva ha terminado!");
                        break;
                    }
                }
            });
            cuentaAtras.start();
        }
    }
}