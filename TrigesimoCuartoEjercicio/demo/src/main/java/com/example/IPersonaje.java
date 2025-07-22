package com.example;

import java.util.ArrayList;

public interface IPersonaje {
    public void setPareja(IPersonaje Pareja);
    public void addHijo(IPersonaje Hijo);
    public boolean esDesendiente(String nombre);
    public String getSexo();
    public void setSexo(String sexo);
    public String getID();
    public void setID(String Id);
    public String getNombre();
    public IPersonaje getPersonaje();
    public ArrayList<IPersonaje> getHijos();
    public IPersonaje getPersonaje(IPersonaje pers);
    public void removeHijo(IPersonaje per);
    public IPersonaje getHijo(String nombre);
    public IPersonaje buscarPadre(String nombreHijo);
}
