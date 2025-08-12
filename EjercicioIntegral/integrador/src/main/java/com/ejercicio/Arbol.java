package com.ejercicio;

public class Arbol extends Planta{
    private String variedad;
    private String tipoDeTronco;
    private int radioTronco;
    private String color;
    private String tipoHojas;

    public Arbol(String nombre, int altoTallo, boolean tieneHojas, String climaIdeal, String variedad, String tipoDeTronco, int radioTronco, String color, String tipoHojas) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.variedad = variedad;
        this.tipoDeTronco = tipoDeTronco;
        this.radioTronco = radioTronco;
        this.color = color;
        this.tipoHojas = tipoHojas;
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Soy un arbol");
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getTipoDeTronco() {
        return tipoDeTronco;
    }

    public void setTipoDeTronco(String tipoDeTronco) {
        this.tipoDeTronco = tipoDeTronco;
    }

    public int getRadioTronco() {
        return radioTronco;
    }

    public void setRadioTronco(int radioTronco) {
        this.radioTronco = radioTronco;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoHojas() {
        return tipoHojas;
    }

    public void setTipoHojas(String tipoHojas) {
        this.tipoHojas = tipoHojas;
    }
}
