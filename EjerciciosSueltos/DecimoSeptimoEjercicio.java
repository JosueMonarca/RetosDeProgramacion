import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
/*
 * EJERCICIO:
 * Utilizando tu lenguaje, emplea 3 mecanismos diferentes para imprimir
 * números del 1 al 10 mediante iteración.
 *
 * DIFICULTAD EXTRA (opcional):
 * Escribe el mayor número de mecanismos que posea tu lenguaje
 * para iterar valores. ¿Eres capaz de utilizar 5? ¿Y 10?
 */
public class DecimoSeptimoEjercicio {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1); // Usando un bucle for
        }

        int j = 1;
        while (j <= 10) {
            System.out.println(j); // Usando un bucle while
            j++;
        }

        int k = 1;
        do {
            System.out.println(k); // Usando un bucle do-while
            k++;
        } while (k <= 10);

        // Usando un bucle for-each (aunque no es típico para números secuenciales)
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int num : numbers) {
            System.out.println(num);
        }

        // Usando Streams (Java 8+)
        IntStream.rangeClosed(1, 10).forEach(System.out::println);

        List<String> lista = List.of("a", "b", "c");
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
        System.out.println(it.next());
        }

        Map<String, Integer> mapa = Map.of("uno", 1, "dos", 2);
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        lista.stream()
        .filter(s -> s.startsWith("a"))
        .forEach(System.out::println);
    }
}
