package ejercicio.cuadragesimo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CajaFuerte cajaF = new CajaFuerte();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean abierto = false;
            int intentos = 0;

            while(!abierto || intentos <=10){
                System.out.print("Introduce la clave de la caja fuerte: ");
                String clave = scanner.nextLine();
                intentos++;

                if(clave.length() == 4){
                    if (cajaF.abrir(clave)) {
                        abierto = true;
                        System.out.println("¡Caja fuerte abierta!");
                        break;
                    } else {
                        System.out.println("Clave incorrecta. Inténtalo de nuevo.");
                        if(!cajaF.obtenerDigitosCoinciden(clave).isEmpty()){
                            System.out.println("Los dígitos que coinciden son: " + cajaF.obtenerDigitosCoinciden(clave));
                        }
                    }
                }else {
                    System.out.println("La clave debe tener 4 dígitos.");
                }
            }
        }

    }
}