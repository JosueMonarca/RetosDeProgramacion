package ejercicio.quincuagesimo;

public interface IObjetivo {
    public void anadirObjetivo(String objetivo);
    public void anadirCantidad(int cantidad);
    public void anadirUnidad(String unidad);
    public void establecerPlazo(int plazo);
    public void establecerPrioridad(int prioridad);
    public String obtenerObjetivo();
    public int obtenerCantidad();
    public String obtenerUnidad();
    public int obtenerPlazo();
    public int obtenerPrioridad();
    public double cantidadSobrePlazo();
}
