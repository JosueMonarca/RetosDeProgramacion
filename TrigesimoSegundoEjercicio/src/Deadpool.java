
import java.security.SecureRandom;

public class Deadpool implements IHeroe{
    private int vida;
    private final int MAXIMODAÑO = 100;

    public Deadpool(int vida){
        this.vida = vida;
    } 

    @Override
    public int getmaximoDaño(){
        return MAXIMODAÑO;
    }

    @Override
    public String getNombre(){
        return "Deadpool";
    }

    @Override
    public void setVida(int vida){
        this.vida = vida;
    }

    @Override
    public int getVida(){
        return vida;
    }

    @Override
    public int getDaño(){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(90) + 11;
    }

    @Override
    public boolean recibioDaño(){
        SecureRandom secureRandom = new SecureRandom();
        return (secureRandom.nextInt(4) != 2);
    }
}
