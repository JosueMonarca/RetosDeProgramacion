package ejercicio.integrador;

public class Videojuego implements IVideojuego {
    private String codigo;
    private String nombre;
    private String consola;
    private String cantidadJugadores;
    private String categoria;

    public Videojuego() {
    }

    public Videojuego(String codigo, String nombre, String consola, String cantidadJugadores, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.consola = consola;
        this.cantidadJugadores = cantidadJugadores;
        this.categoria = categoria;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getConsola() {
        return consola;
    }

    @Override
    public void setConsola(String consola) {
        this.consola = consola;
    }

    @Override
    public String getCantidadJugadores() {
        return cantidadJugadores;
    }

    @Override
    public void setCantidadJugadores(String cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
