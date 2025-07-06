public class Vehiculo {
    protected String velocidad;
    protected String tipo;
    protected String nombre;

    public Vehiculo(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.velocidad = "0 km/h";
    }

    protected void acelerar(){
        velocidad = "Acelerando a 60 km/h";
        System.out.println(velocidad);
    }

    protected void frenar(){
        velocidad = "Frenando a 0 km/h";
        System.out.println(velocidad);
    }

    public String getVelocidad() {
        return velocidad;
    }

    public String getTipo() {
        return tipo;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad='" + velocidad + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
