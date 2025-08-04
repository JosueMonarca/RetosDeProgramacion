package ejercicio.cuadragesimo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CajaFuerte cajaF = new CajaFuerte();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean abierto = false;
            int intentos = 0;

            while(!abierto && intentos <=10){
                System.out.print("Introduce la clave de la caja fuerte: ");
                String clave = scanner.nextLine();
                intentos++;

                if(clave.length() == 4){
                    if(clave.matches("[A-C1-3]+")) {
                        System.out.println("Clave válida.");
                    } else {
                        System.out.println("La clave solo puede contener letras A, B, C y números 1, 2, 3.");
                        continue;
                    }
                    if (cajaF.abrir(clave)) {
                        abierto = true;
                        System.out.println("¡Caja fuerte abierta!");
                        break;
                    } else {
                        System.out.println("Clave incorrecta. Inténtalo de nuevo.");
                        if(!cajaF.obtenerDigitosCoinciden(clave).isEmpty()){
                            System.out.println("Los dígitos que coinciden son: " + cajaF.obtenerDigitosCoinciden(clave));
                            for (int i = 0; i < clave.length(); i++) {
                                System.out.println(cajaF.nivelCoincidencia(clave.charAt(i), i));
                            }
                        }
                    }
                }else {
                    System.out.println("La clave debe tener 4 dígitos.");
                }
            }
        }

    }
}