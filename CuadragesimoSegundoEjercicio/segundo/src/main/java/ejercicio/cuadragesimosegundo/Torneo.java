package ejercicio.cuadragesimosegundo;

import java.util.ArrayList;
import java.util.Collections;

public class Torneo {
    private final ArrayList<ILuchador>participantes = new ArrayList<>();
    
    public void addParticipante(ILuchador peleador){
        if (peleador.getDefensa() == 0) peleador.setDefensaRandom();
        if (peleador.getAtaque() == 0) peleador.setAtaqueRandom();
        if (peleador.getVelocidad() == 0) peleador.setVelocidadRandom();
        if (!peleador.getEstaVivo()) peleador.setVivo(true);
        participantes.add(peleador);
    }

public void iniciarTorneo() {
    if (EsPotenciaDe2(participantes.size())) {
        Collections.shuffle(participantes); // Mezcla inicial
        ArrayList<ILuchador> rondaActual = new ArrayList<>(participantes); // copia segura

        while (rondaActual.size() > 1) {
            ArrayList<ILuchador> siguienteRonda = new ArrayList<>();

            for (int i = 0; i < rondaActual.size(); i += 2) {
                ILuchador luchador1 = rondaActual.get(i);
                ILuchador luchador2 = rondaActual.get(i + 1);

                System.out.println();

                System.out.println("🔥 NUEVA BATALLA: " + luchador1.getNombre() + " VS " + luchador2.getNombre() + " 🔥");

                System.out.println();

                Batalla batalla = new Batalla(luchador1, luchador2);
                batalla.batalla();

                if (batalla.getGanador() == luchador1) {
                    luchador2.setVivo(false);
                    siguienteRonda.add(luchador1);
                } else {
                    luchador1.setVivo(false);
                    siguienteRonda.add(luchador2);
                }
            }
            rondaActual = siguienteRonda; // pasar a la siguiente ronda

            rondaActual.forEach(peleador ->{
                peleador.setSalud(100);
            });

        }
        System.out.println();
        ILuchador campeon = rondaActual.get(0);
        System.out.println("¡El ganador del torneo es: " + campeon.getNombre() + "!");
        System.out.println("Ataque: " + campeon.getAtaque());
        System.out.println("Defensa: " + campeon.getDefensa());
        System.out.println("Velocidad: " + campeon.getVelocidad());

    } else {
        System.out.println("No hay suficientes participantes o no son potencia de 2.");
    }
}

    private static boolean EsPotenciaDe2(int num){
        return num > 0 && (num  & (num -1)) == 0;
    }
}
