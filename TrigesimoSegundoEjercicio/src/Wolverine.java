import java.security.SecureRandom;

public class Wolverine implements IHeroe{
    private int vida;
    private final int MAXIMODAÑO = 120;

    public Wolverine(int vida){
        this.vida = vida;
    }

    @Override
    public int getmaximoDaño(){
        return MAXIMODAÑO;
    }

    @Override
    public String getNombre(){
        return "Wolverine";
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
        return secureRandom.nextInt(110) + 11;
    }

    @Override
    public boolean recibioDaño(){
        SecureRandom secureRandom = new SecureRandom();
        return (secureRandom.nextInt(5) != 2);
    }
}
