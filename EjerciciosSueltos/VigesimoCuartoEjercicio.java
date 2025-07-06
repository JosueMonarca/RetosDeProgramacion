/*
 * EJERCICIO:
 * Explora el concepto de "decorador" y muestra cómo crearlo
 * con un ejemplo genérico.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un decorador que sea capaz de contabilizar cuántas veces
 * se ha llamado a una función y aplícalo a una función de tu elección.
 */
public class VigesimoCuartoEjercicio {
    public static void main(String[] args) {
        Runnable funcion = () -> System.out.println("Soy Josue");
        Runnable funcionDecorada = contarTiempoEjecucion(funcion);
        funcionDecorada.run();
    }

    public static Runnable contarTiempoEjecucion(Runnable funcion){
        return () -> {
            long inicio = System.currentTimeMillis();
            funcion.run();
            long fin = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");
        };
    }
}
