package com.example;

import java.util.ArrayList;

import com.example.exceptions.PersonajeNoEncontradoException;

public class Controlador {
    private static Controlador controlador;
    private final ArrayList <Personaje> PERSONAJES;

    private Controlador(){
        PERSONAJES = new ArrayList<>();
    }

       // Método de acceso global (lazy loading)
    public static Controlador getInstancia() {
        if (controlador == null) {
            controlador = new Controlador();
        }
        return controlador;
    }

    public void addPersonaje(IPersonaje pers, IPersonaje padre) {
        if (padre == null || !existe(padre.getNombre())) {
            throw new PersonajeNoEncontradoException("El padre no existe.");
        }
    
        for (IPersonaje root : PERSONAJES) {
            IPersonaje nodoPadre = root.getPersonaje(padre);
            if (nodoPadre != null) {
                nodoPadre.addHijo(pers);
                return;
            }
        }
    
        throw new PersonajeNoEncontradoException("No se pudo encontrar el padre en la estructura.");
    }

    /**
     * @param perso
     */
    public void removePersonaje(IPersonaje perso){
        if(perso == null || !existe(perso.getNombre())){
            throw new PersonajeNoEncontradoException("No existe esa persona");
        }
        else{
            for (IPersonaje root : PERSONAJES) {
            IPersonaje nodoPadre = root.buscarPadre(perso.getNombre());
                if (nodoPadre != null && nodoPadre.getHijos().contains(perso)) {
                    nodoPadre.removeHijo(perso);
                    return;
                }
            }
        }
    }

    public boolean existe(String nombre){
        boolean es = false;

        for(IPersonaje per : PERSONAJES){
            if(per.getNombre().equalsIgnoreCase(nombre)){
                return per.getNombre().equalsIgnoreCase(nombre);
            }
            else if (per.esDesendiente(nombre)) {
                return true;
            }
        }

        return es;
    }

    public IPersonaje getPersonaje(String nombre){
        if(existe(nombre)){
            return PERSONAJES.get(0).getHijo(nombre);
        }
        return null;
    }

    public ArrayList<Personaje> getArbol(){
        return PERSONAJES;
    }
}
