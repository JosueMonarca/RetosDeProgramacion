package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String ruta = "demo\\src\\main\\resources\\Usuarios.csv";
        String linea;
        ArrayList<ArrayList<String>> tabla = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
            while((linea= br.readLine()) != null){
                String[] columnas = linea.split(",");

                if(columnas.length != 4)continue;
                
                ArrayList<String> fila = new ArrayList<>();
                fila.add(columnas[0]);
                fila.add(columnas[1]);
                fila.add(columnas[2]);
                fila.add(columnas[3]);
                tabla.add(fila);
            } 
            
            boolean estaVacia = false;
            int numeroDePremios = 0;
            SecureRandom sr = new SecureRandom();
            String[] ids = {"-1","-1"};

            while (!estaVacia) {

                int fila = sr.nextInt(tabla.size());

                if(ids[0].equalsIgnoreCase(tabla.get(fila).get(0)) || ids[1].equalsIgnoreCase(tabla.get(fila).get(0)))  continue;

                if(tabla.get(fila).get(2).equalsIgnoreCase("activo")){
                    switch (numeroDePremios){
                        case 0 -> {
                            System.out.println(tabla.get(fila).get(3)+" felicidades usted gano una suscripción");
                            numeroDePremios++;
                            ids[0] = tabla.get(fila).get(0);
                        }
                        case 1 -> {
                            System.out.println(tabla.get(fila).get(3)+" felicidades usted gano un descuento"); 
                            numeroDePremios++;
                            ids[1] = tabla.get(fila).get(0);
                        }
                        case 2 -> {System.out.println(tabla.get(fila).get(3)+" felicidades usted gano un libro"); estaVacia = true;}
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}