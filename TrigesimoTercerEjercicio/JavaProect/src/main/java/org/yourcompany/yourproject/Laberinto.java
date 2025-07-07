/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author jmona
 */
public class Laberinto {

    public static void main(String[] args) {
        Matris lab = new Matris();
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================Bienvenido al laberinto de mickey=============================");

        while(continuar){
            showLab(lab);
            Entrada(scanner, lab);
            if(lab.getHaSalido()){
                continuar = false;
                System.out.println("¡Felicidades! ¡Mickey ha escapado del laberinto!");
            }
        }
    }

    private static void showLab(Matris ma){
        for (int i = 0; i < ma.getHeight(); i++) {
            for (int j = 0; j < ma.getWidth(); j++) {
                System.out.print(ma.getLaberinto()[i][j]);
            }
            System.out.println();
        }
    }

    private static void Entrada(Scanner scanner, Matris ma){
        System.out.println("Hacia donde desea moverse \"w\" \"s\" \"d\" \"a\"");
        String letra = scanner.nextLine();

        if(letra.length() == 1){
            ma.moverConTecla(letra.charAt(0));
        }else{
            System.out.println("Por favor ingrese un caracter valido");
        }
    }
}
