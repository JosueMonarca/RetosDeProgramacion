/* 
 * DIFICULTAD EXTRA (opcional):
 * Crea un pequeño sistema de gestión del estado de pedidos.
 * Implementa una clase que defina un pedido con las siguientes características:
 * - El pedido tiene un identificador y un estado.
 * - El estado es un Enum con estos valores: PENDIENTE, ENVIADO, ENTREGADO y CANCELADO.
 * - Implementa las funciones que sirvan para modificar el estado:
 *   - Pedido enviado
 *   - Pedido cancelado
 *   - Pedido entregado
 *   (Establece una lógica, por ejemplo, no se puede entregar si no se ha enviado, etc...)
 * - Implementa una función para mostrar un texto descriptivo según el estado actual.
 * - Crea diferentes pedidos y muestra cómo se interactúa con ellos. 
 */

public class pedido {

    private int id;
    private EstadoPedido estado;

    public pedido(){
        this.estado = EstadoPedido.PENDIENTE; // Estado inicial por defecto
        this.id = 0; // ID por defecto
    }

    public pedido (int id, EstadoPedido estado) {
        this.id = id;
        this.estado = estado;
    }

    public pedido(int id) {
        this.id = id;
        this.estado = EstadoPedido.PENDIENTE; // Estado inicial
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void enviarPedido(){
        switch (this.estado) {
            case PENDIENTE -> {
                this.estado = EstadoPedido.ENVIADO;
                System.out.println("Pedido " + id + " enviado.");
            }
            case CANCELADO -> System.out.println("No se puede enviar su pedido porque fue cancelado");
            case ENTREGADO -> System.out.println("Su pedido ya fue entregado");
            case ENVIADO -> System.out.println("El pedido ya fue enviado");
        }
    }

    public boolean fueEntregado(){
        return this.estado == EstadoPedido.ENTREGADO;
    }

    public void entregarPedido(){
        switch (this.estado){
            case ENVIADO ->{
                this.estado = EstadoPedido.ENTREGADO;
                System.out.println("Pedido "+ id + " entregado");
            }
            case CANCELADO -> System.out.println("No se puede enviar su pedido porque fue cancelado");
            case PENDIENTE -> System.out.println(  "Su pedido no puede ser entregado por que no a sido enviado");
            case ENTREGADO -> System.out.println("Su pedido ya fue entregado");
        }
    }

    public void cancelarPedido(){
        if(this.estado == EstadoPedido.CANCELADO){
            System.out.println("No se puede cancelar 2 veces un pedido");
        }else{
            this.estado = EstadoPedido.CANCELADO;
            System.out.println("Su pedido a sido cancelado con exito");
        }
    }
}
