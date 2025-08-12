package com.ejercicio;

public abstract class Planta {
    protected String nombre;
    protected int altoTallo;
    protected boolean tieneHojas;
    protected String climaIdeal;

    public Planta(){
        this.nombre = "";
        this.altoTallo = 0;
        this.tieneHojas = false;
        this.climaIdeal = "";
    }

    public Planta(String nombre, int altoTallo, boolean tieneHojas, String climaIdeal) {
        this.nombre = nombre;
        this.altoTallo = altoTallo;
        this.tieneHojas = tieneHojas;
        this.climaIdeal = climaIdeal;
    }
    
    public abstract void mostrarTipo();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltoTallo() {
        return altoTallo;
    }

    public void setAltoTallo(int altoTallo) {
        this.altoTallo = altoTallo;
    }

    public boolean isTieneHojas() {
        return tieneHojas;
    }

    public void setTieneHojas(boolean tieneHojas) {
        this.tieneHojas = tieneHojas;
    }

    public String getClimaIdeal() {
        return climaIdeal;
    }

    public void setClimaIdeal(String climaIdeal) {
        this.climaIdeal = climaIdeal;
    }
}
