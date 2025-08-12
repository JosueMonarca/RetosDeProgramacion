package com.ejercicio;

public class Flor extends Planta{
    private String colorPetalos;
    private int promedioPetalos;
    private String colorPistillo;
    private String variedadFlor;
    private String estacionFlorece;

    public Flor(String colorPetalos, String colorPistillo, String estacionFlorece, int promedioPetalos, String variedadFlor, String nombre, int altoTallo, boolean tieneHojas, String climaIdeal) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.colorPetalos = colorPetalos;
        this.colorPistillo = colorPistillo;
        this.estacionFlorece = estacionFlorece;
        this.promedioPetalos = promedioPetalos;
        this.variedadFlor = variedadFlor;
    }

    @Override
    public void mostrarTipo() {
        System.out.println("soy una flor");
    }

    public String getColorPetalos() {
        return colorPetalos;
    }

    public void setColorPetalos(String colorPetalos) {
        this.colorPetalos = colorPetalos;
    }

    public int getPromedioPetalos() {
        return promedioPetalos;
    }

    public void setPromedioPetalos(int promedioPetalos) {
        this.promedioPetalos = promedioPetalos;
    }

    public String getColorPistillo() {
        return colorPistillo;
    }

    public void setColorPistillo(String colorPistillo) {
        this.colorPistillo = colorPistillo;
    }

    public String getVariedadFlor() {
        return variedadFlor;
    }

    public void setVariedadFlor(String variedadFlor) {
        this.variedadFlor = variedadFlor;
    }

    public String getEstacionFlorece() {
        return estacionFlorece;
    }

    public void setEstacionFlorece(String estacionFlorece) {
        this.estacionFlorece = estacionFlorece;
    }

}
