
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
 * EJERCICIO:
 * Utilizando tu lenguaje, crea un programa capaz de ejecutar de manera
 * asíncrona una función que tardará en finalizar un número concreto de
 * segundos parametrizables. También debes poder asignarle un nombre.
 * La función imprime su nombre, cuándo empieza, el tiempo que durará
 * su ejecución y cuando finaliza.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utilizando el concepto de asincronía y la función anterior, crea
 * el siguiente programa que ejecuta en este orden:
 * - Una función C que dura 3 segundos.
 * - Una función B que dura 2 segundos.
 * - Una función A que dura 1 segundo.
 * - Una función D que dura 1 segundo.
 * - Las funciones C, B y A se ejecutan en paralelo.
 * - La función D comienza su ejecución cuando las 3 anteriores han finalizado.
 */

public class QuinceavoEjercicio {

    public static CompletableFuture<Void> tareaAsicrona(String nombre, int segundos){
        return CompletableFuture.runAsync(()->{
            System.out.println("["+LocalTime.now()+"] "+nombre + "empieza, duracion "+ segundos+"s");

            try {
                Thread.sleep(segundos);
            } catch (InterruptedException e) {
                System.out.println(nombre+ " fue interrumpido");
            }

            System.out.println(nombre + " termina");
        });
    } 

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        CompletableFuture<Void> a = tareaAsicrona("A",1 );
        CompletableFuture<Void> b = tareaAsicrona("B", 2);
        CompletableFuture<Void> c = tareaAsicrona("C", 3);

        CompletableFuture<Void> d = CompletableFuture.allOf(a,b,c).thenCompose(ignored -> tareaAsicrona("D",1));

        d.get();
    }
}
