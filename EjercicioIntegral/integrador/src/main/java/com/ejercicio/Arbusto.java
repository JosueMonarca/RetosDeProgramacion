package com.ejercicio;

public class Arbusto extends Planta{
    private String anchoArbusto;
    private boolean esDomestico;
    private String variedadArbusto;
    private String colorHojas;
    private boolean sePoda;

    public Arbusto(String anchoArbusto, String colorHojas, boolean esDomestico, boolean sePoda, String variedadArbusto, String nombre, int altoTallo, boolean tieneHojas, String climaIdeal) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.anchoArbusto = anchoArbusto;
        this.colorHojas = colorHojas;
        this.esDomestico = esDomestico;
        this.sePoda = sePoda;
        this.variedadArbusto = variedadArbusto;
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Soy un arbusto");
    }

    public String getAnchoArbusto() {
        return anchoArbusto;
    }

    public void setAnchoArbusto(String anchoArbusto) {
        this.anchoArbusto = anchoArbusto;
    }

    public boolean isEsDomestico() {
        return esDomestico;
    }

    public void setEsDomestico(boolean esDomestico) {
        this.esDomestico = esDomestico;
    }

    public String getVariedadArbusto() {
        return variedadArbusto;
    }

    public void setVariedadArbusto(String variedadArbusto) {
        this.variedadArbusto = variedadArbusto;
    }

    public String getColorHojas() {
        return colorHojas;
    }

    public void setColorHojas(String colorHojas) {
        this.colorHojas = colorHojas;
    }

    public boolean isSePoda() {
        return sePoda;
    }

    public void setSePoda(boolean sePoda) {
        this.sePoda = sePoda;
    }
}
