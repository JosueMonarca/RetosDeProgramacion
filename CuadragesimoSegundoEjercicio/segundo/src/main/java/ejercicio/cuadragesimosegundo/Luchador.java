package ejercicio.cuadragesimosegundo;

import java.security.SecureRandom;

public class Luchador implements ILuchador{
    private final String  nombre;
    private int salud = 100;
    private int velocidad;
    private int ataque;
    private int defensa;
    private boolean estaVivo;

    public Luchador(String nombre){
        this.nombre = nombre;
    }

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public void setSalud(int salud) {
        this.salud = salud;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public int getAtaque() {
        return ataque;
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public int getDefensa() {
        return defensa;
    }

    @Override
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setAtaqueRandom(){
        SecureRandom sr = new SecureRandom();
        this.setAtaque(sr.nextInt(101));
    }

    @Override
    public void setDefensaRandom(){
        SecureRandom sr = new SecureRandom();
        this.setDefensa(sr.nextInt(100)+1);
    }

    @Override
    public void setVelocidadRandom(){
        SecureRandom sr = new SecureRandom();
        this.setVelocidad(sr.nextInt(100)+1);
    }

    @Override
    public void setVivo(boolean  estaVivo) {
        this.estaVivo = estaVivo;
    }

    @Override
    public boolean getEstaVivo() {
        return estaVivo;
    }
}
