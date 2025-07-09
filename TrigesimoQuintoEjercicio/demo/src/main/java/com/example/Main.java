package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int anillo;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el numero de anillos");
            String anillos = scanner.nextLine();

            try {
                anillo = Integer.parseInt(anillos);

                if(anillo < 6){
                    System.out.println("No se puede repartir con menos 6");
                }
                else{
                    anillo --;
                    int[] sumandos = obtenerSumas(anillo);

                    if(sumandos != null){
                        System.out.println("Los hombres tienen " + sumandos[0] + " anillos");
                        System.out.println("Los elfos tienen " + sumandos[1] + " anillos");
                        System.out.println("Los enanos tienen "+ sumandos[2] + " anillos");
                        System.out.println("y sauron recibe 1 anillo");
                    }else{
                        System.out.println("No se puede poner ");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero por favor");
            }
        }
    }
    
    private static ArrayList<Integer> getPar(int num){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < num; i++){
            if(i%2 == 0){
                array.add(i);
            }
        }
        return array;
    }

    private static ArrayList<Integer> getImpar(int num){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < num; i++){
            if(i%2 != 0){
                array.add(i);
            }
        }
        return array;
    }

    private static ArrayList<Integer> obtenerPrimosHasta(int n) {
        ArrayList<Integer> primos = new ArrayList<>();

        if (n < 2) return primos;

        boolean[] esPrimo = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            esPrimo[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= n; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (esPrimo[i]) {
                primos.add(i);
            }
        }

        return primos;
    }

    private static int[] obtenerSumas(int dijito){
        ArrayList<Integer> pares = getPar(dijito);
        ArrayList<Integer> impares = getImpar(dijito);
        ArrayList<Integer> primos = obtenerPrimosHasta(dijito);

        for (Integer elem : pares) {
            for (Integer elemen : impares) {
                for(Integer element : primos){
                    if(elem != 0 && elemen != 0 && element != 0){
                        if((elem + element + elemen) == dijito){
                            int[] sumandos = {elem, elemen, element};
                            return sumandos;
                        }
                    }
                }
            }
        }
    return null;
    }
}