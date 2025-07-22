package ejercicio.cuadragesimosegundo;

public interface ILuchador {

    public int getSalud();

    public void setSalud(int salud);

    public int getVelocidad();

    public void setVelocidad(int velocidad);

    public int getAtaque() ;

    public void setAtaque(int ataque) ;

    public int getDefensa();

    public void setDefensa(int defensa) ;

    public String getNombre();

    public void setAtaqueRandom();

    public void setDefensaRandom();

    public void setVelocidadRandom();

    public void setVivo(boolean  estaVivo);

    public boolean getEstaVivo();
}
