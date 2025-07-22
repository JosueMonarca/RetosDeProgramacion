package ejercicio.cuadragesimosegundo;

import java.security.SecureRandom;

public class Batalla {
    private final ILuchador peleador1;
    private final ILuchador peleador2;

    public Batalla(ILuchador peleador1, ILuchador peleador2){
        this.peleador1 = peleador1;
        this.peleador2 = peleador2;
    }

    public void batalla(){
        int primerPeleador = Math.max(peleador1.getVelocidad(), peleador2.getVelocidad());
        boolean alguienPerdio = false;
        int turno = 0;
        ILuchador primerLuchador;
        ILuchador segundoLuchador;

        if(primerPeleador == peleador1.getVelocidad()){
            primerLuchador = peleador1;
            segundoLuchador= peleador2;
        }else{
            primerLuchador = peleador2;
            segundoLuchador = peleador1;
        }
        
        while (!alguienPerdio) {
            String mensage;
            int dano;
            turno++;
            boolean bloqueo = new SecureRandom().nextInt(5) == 2;

            if(!bloqueo){
                if(turno % 2 != 0) dano = ataque(primerLuchador, segundoLuchador);
                else dano = ataque(segundoLuchador, primerLuchador);

                if(turno % 2 != 0) mensage = primerLuchador.getNombre() + " hizo " + dano + " de daño a "+segundoLuchador.getNombre();
                else mensage = segundoLuchador.getNombre()+ " hizo "+dano+" de daño a "+primerLuchador.getNombre();

                System.out.println(mensage);
            }else{
                if(turno % 2 != 0) mensage = segundoLuchador.getNombre() + " bloqueo el ataque de "+ primerLuchador.getNombre();
                else mensage = primerLuchador.getNombre() + " bloqueo el ataque de " + segundoLuchador.getNombre();
                System.out.println(mensage);
            }

            if(primerLuchador.getSalud() <= 0) {
                System.out.println(primerLuchador.getNombre()+" ha perdido");
                alguienPerdio = true;
            }
            if(segundoLuchador.getSalud() <= 0) {
                System.out.println(segundoLuchador.getNombre()+ " ha perdido");
                alguienPerdio = true;
            }
        }
    }

    private static int ataque(ILuchador atacante, ILuchador atacado){
        
        if(atacante.getAtaque() >  atacado.getDefensa()){
            int dano = atacante.getAtaque() - atacado.getDefensa();
            atacado.setSalud(atacado.getSalud()-dano);
            return dano;
        }else{
            int dano = atacante.getAtaque()/10;
            atacado.setSalud(atacado.getSalud()-dano);
            return dano;
        }
        
    }

    public ILuchador getGanador(){
        if(peleador1.getSalud() <= 0) return peleador2;
        if(peleador2.getSalud() <= 0) return peleador1;
        else return null;
    }
}
