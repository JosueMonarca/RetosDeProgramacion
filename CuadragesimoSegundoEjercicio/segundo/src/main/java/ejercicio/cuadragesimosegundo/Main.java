package ejercicio.cuadragesimosegundo;
/*
 * EJERCICIO:
 * ¡El último videojuego de Dragon Ball ya está aquí!
 * Se llama Dragon Ball: Sparking! ZERO.
 *
 * Simula un Torneo de Artes Marciales, al más puro estilo
 * de la saga, donde participarán diferentes luchadores, y el
 * sistema decidirá quién es el ganador.
 *
 * Luchadores:
 * - Nombre.
 * - Tres atributos: velocidad, ataque y defensa
 *   (con valores entre 0 a 100 que tú decidirás).
 * - Comienza cada batalla con 100 de salud.
 * Batalla:
 * - En cada batalla se enfrentan 2 luchadores.
 * - El luchador con más velocidad comienza atacando.
 * - El daño se calcula restando el daño de ataque del
 *   atacante menos la defensa del oponente.
 * - El oponente siempre tiene un 20% de posibilidad de
 *   esquivar el ataque.
 * - Si la defensa es mayor que el ataque, recibe un 10%
 *   del daño de ataque.
 * - Después de cada turno y ataque, el oponente pierde salud.
 * - La batalla finaliza cuando un luchador pierde toda su salud.
 * Torneo:
 * - Un torneo sólo es válido con un número de luchadores
 *   potencia de 2.
 * - El torneo debe crear parejas al azar en cada ronda.
 * - Los luchadores se enfrentan en rondas eliminatorias.
 * - El ganador avanza a la siguiente ronda hasta que sólo
 *   quede uno.
 * - Debes mostrar por consola todo lo que sucede en el torneo,
 *   así como el ganador.
 */
public class Main {
    public static void main(String[] args) {
        ILuchador peleador1 = new Luchador("Goku");
        ILuchador peleador2 = new Luchador("pikoro");
        ILuchador peleador3 = new Luchador("Gohan");
        ILuchador peleador4 = new Luchador("krilin");
        ILuchador peleador5 = new Luchador("frezer");
        ILuchador peleador6 = new Luchador("cell");
        ILuchador peleador7 = new Luchador("vegeta");
        ILuchador peleador8 = new Luchador("trunks");

        Torneo torneo = new Torneo();
        torneo.addParticipante(peleador8);
        torneo.addParticipante(peleador7);
        torneo.addParticipante(peleador6);
        torneo.addParticipante(peleador5);
        torneo.addParticipante(peleador4);
        torneo.addParticipante(peleador3);
        torneo.addParticipante(peleador2);
        torneo.addParticipante(peleador1);
        
        torneo.iniciarTorneo();
    }
}