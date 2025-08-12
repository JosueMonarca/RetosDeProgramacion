package com.ejercicio;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol("arbol", 12, false, "culaquiera", "ni puta idea", "verde", 0, null, null);
        Flor flor = new Flor("rojo", "amarillo", "primavera", 5, "rosa", "flor", 3, true, "templado");
        Arbusto arbusto = new Arbusto("1 metro", "verde", true, false, "bajo", "arbusto", 2, true, "templado");

        arbol.mostrarTipo();
        flor.mostrarTipo();
        arbusto.mostrarTipo();
        
    }
}