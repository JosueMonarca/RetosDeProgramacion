package com.example;

import java.util.ArrayList;

public class GestorDeParentescos {
    private static GestorDeParentescos instancia;
    private ArrayList<IPersonaje> arbol;
    private final IPersonaje ANCESTROCOMUN = new Personaje("Aeogon el conquistador", "M", "123456");

    private GestorDeParentescos(){

    }

    public GestorDeParentescos getInstancia(){
        if(instancia == null){
            instancia = new GestorDeParentescos();
        }
        return instancia;
    }

    public void setTree(ArrayList<IPersonaje> array){
        arbol = array;
    }

    public ArrayList<IPersonaje> getTree(){
        return arbol;
    }

    public IPersonaje getHijo(String nombre) {
        for(IPersonaje per : arbol){
            if(per.getNombre().equalsIgnoreCase(nombre)){
                return per;
            }
            else {
                IPersonaje found = per.getHijo(nombre);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }


    public IPersonaje buscarPadre(String nombreHijo) {
        for (IPersonaje hijo : arbol) {
            if (hijo.getNombre().equalsIgnoreCase(nombreHijo)) {
                return hijo; // ← Soy el padre
            } else {
                IPersonaje posiblePadre = hijo.buscarPadre(nombreHijo);
                if (posiblePadre != null) {
                    return posiblePadre;
                }
            }
        }
        return null;  
    }

    public static void printAll(IPersonaje personaje){
        ArrayList <IPersonaje> hijos = personaje.getHijos();
        if( hijos != null){
            hijos.forEach(hijo ->{
            System.out.println(hijo.getNombre());
            Personaje.printAll(hijo);
            });
        }
    }
}
