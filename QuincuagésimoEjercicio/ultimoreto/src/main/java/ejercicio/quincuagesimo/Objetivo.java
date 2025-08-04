package ejercicio.quincuagesimo;

public class Objetivo implements IObjetivo {
    private String objetivo;
    private int cantidad;
    private String unidad;
    private int plazo;
    private int prioridad;

    @Override
    public void anadirObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public void anadirCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void anadirUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public void establecerPlazo(int plazo) {
        if(plazo < 13 && plazo > 0)this.plazo = plazo;
        else throw new IllegalArgumentException("El plazo debe estar entre 1 y 12 meses.");
    }

    @Override
    public void establecerPrioridad(int prioridad) {
        if(prioridad > 0 && prioridad < 11)this.prioridad = prioridad;
        else throw new IllegalArgumentException("La prioridad debe ser un número positivo.");
    }

    @Override
    public String obtenerObjetivo() {
        return objetivo;
    }

    @Override
    public int obtenerCantidad() {
        return cantidad;
    }

    @Override
    public String obtenerUnidad() {
        return unidad;
    }

    @Override
    public int obtenerPlazo() {
        return plazo;
    }

    @Override
    public int obtenerPrioridad() {
        return prioridad;
    }

    @Override
    public double cantidadSobrePlazo() {
        if (plazo == 0) {
            throw new IllegalArgumentException("El plazo no puede ser cero.");
        }
        return (double) cantidad / plazo;
    }
}
