/*
 * EJERCICIO:
 * Explora el concepto de callback en tu lenguaje creando un ejemplo
 * simple (a tu elección) que muestre su funcionamiento.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un simulador de pedidos de un restaurante utilizando callbacks.
 * Estará formado por una función que procesa pedidos.
 * Debe aceptar el nombre del plato, una callback de confirmación, una
 * de listo y otra de entrega.
 * - Debe imprimir un confirmación cuando empiece el procesamiento.
 * - Debe simular un tiempo aleatorio entre 1 a 10 segundos entre
 *   procesos.
 * - Debe invocar a cada callback siguiendo un orden de procesado.
 * - Debe notificar que el plato está listo o ha sido entregado.
 */
public class VigesimoPrimerEjercicio {
    public static void main(String[] args) {
        procesarPedido("Carnitas", () -> System.out.println(" Pedido de carnitas recibido." ),
                                    () -> System.out.println("Pedido de carnitas Listo."),
                                    () -> System.out.println("Pedido de carnitas entregado.")
                                    );
    }

    private static void procesarPedido(String nombrePlato, Runnable pedirPedido, Runnable pedidoListo, Runnable pedidoEntregado){
        System.out.println("Procesando el pedido: "+ nombrePlato);
        pedirPedido.run();
        esperaAleatoria();
        pedidoListo.run();
        esperaAleatoria();
        pedidoEntregado.run();
    }

    private static void esperaAleatoria(){
        try {
            Thread.sleep((long)(Math.random() * 10000));
        } catch (InterruptedException e) {
            System.err.println("Error al simular el tiempo de procesamiento: " + e.getMessage());
        }
    }
}
