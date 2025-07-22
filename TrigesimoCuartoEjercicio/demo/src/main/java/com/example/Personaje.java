package com.example;

import java.util.ArrayList;

public class Personaje implements IPersonaje {
    private final String nombre;
    private String sexo;
    private IPersonaje pareja;
    private final ArrayList <IPersonaje> hijos;
    private String ID;

    public Personaje(String nombre, String sexo, String ID){
        this.nombre = nombre;
        this.sexo = sexo;
        this.ID = ID;
        hijos = new ArrayList<>();
    }

    @Override
    public void setPareja(IPersonaje pareja) {
        this.pareja = pareja;
    }

    public IPersonaje getPareja(){
        return pareja;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String Id) {
        this.ID = Id;
    }

        @Override
    public void addHijo(IPersonaje hijo) {
        hijos.add(hijo);
    }

    @Override
    public boolean esDesendiente(String nombre) {
        boolean es = false;

        for(IPersonaje per : hijos){
            if(per.getNombre().equalsIgnoreCase(nombre)){
                return per.getNombre().equalsIgnoreCase(nombre);
            }
            else if (per.esDesendiente(nombre)) {
                return true;
            }
        }

        return es;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public IPersonaje getPersonaje() {
        return this;
    }

    @Override
    public ArrayList<IPersonaje> getHijos() {
        return hijos;
    }

    @Override
    public IPersonaje getPersonaje(IPersonaje pers) {
        for(IPersonaje per : hijos){
            if(per.getID().equalsIgnoreCase(pers.getID())){
                return per;
            }
            else {
                IPersonaje found = per.getPersonaje(pers);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    @Override
    public void removeHijo(IPersonaje per) {
        hijos.remove(per);
    }

    @Override
    public IPersonaje getHijo(String nombre) {
        for(IPersonaje per : hijos){
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

    @Override
    public IPersonaje buscarPadre(String nombreHijo) {
        for (IPersonaje hijo : hijos) {
            if (hijo.getNombre().equalsIgnoreCase(nombreHijo)) {
                return this; // ← Soy el padre
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
