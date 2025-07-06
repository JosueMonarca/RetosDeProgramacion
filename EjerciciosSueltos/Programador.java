public class Programador extends Empleado {
    private String lenguaje;
    private String proyecto;

    public Programador(int id, String nombre, String lenguaje, String proyecto) {
        super(id, nombre);
        this.lenguaje = lenguaje;
        this.proyecto = proyecto;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "id=" + getID() +
                ", nombre='" + getNombre() + '\'' +
                ", lenguaje='" + lenguaje + '\'' +
                ", proyecto='" + proyecto + '\'' +
                '}';
    }
}
