package com.josue;

import java.security.SecureRandom;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void main(String[] args) {
        showFechas();
        sistemaDeSeguridad();
    }
    private static void showFechas(){
        int añoActual  = LocalDate.now().getYear();
        int añoFinal = 1940 + 100;

        for(int i = añoActual; i <= añoFinal ; i++){
            LocalDate septiembre = LocalDate.of(i, Month.SEPTEMBER,1);

            LocalDate primerSabado = septiembre.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
            LocalDate tercerSabado = primerSabado.plusWeeks(2);
            System.out.println("Batman day del " + i + " sera el " + tercerSabado);
        }
    }

    private static void sistemaDeSeguridad(){
        int[][] gotica = new int[20][20];
        SecureRandom sr = new SecureRandom();
        
        for (int idx = 0; idx < gotica.length; idx++) {
            for (int ind = 0; ind < gotica[0].length; ind++) {
                gotica[idx][ind] = sr.nextInt(11);
            }
        }

        for(int i =  0; i < gotica.length; i++){
            for(int j = 0; j < gotica[0].length; j++){
                boolean activar = recorrerSeccion(gotica, i, j);

                if (activar) {
                    int suma = obtenerSuma(gotica, i, j);
                    System.out.printf("La suma del cuadrante es %d activa el protocolo de seguridad en el cuadrante [%d, %d] que está a %.2f cuadros de la baticueva%n",
                            suma, i, j,(double) (Math.abs(i) + Math.abs( j)));
                }
                j=j+3;
            }
            i = i+3;
        }
    }

    private static boolean recorrerSeccion(int[][] gotica, int x, int y){
        int suma = 0;
        for(int i = x ; i < x+2 ; i++){
            for(int j = y; j < y+2 ; j++){
                suma += gotica[i][j];
                if(suma >= 20) {
                    return true;
                }
            }
        }
        return  false;
    }

        private static int obtenerSuma(int[][] gotica, int x, int y){
        int suma = 0;
        for(int i = x ; i < x+2 ; i++){
            for(int j = y; j < y+2 ; j++){
                suma += gotica[i][j];
                if(suma >= 20) {
                    return suma;
                }
            }
        }
        return suma;
    }
}