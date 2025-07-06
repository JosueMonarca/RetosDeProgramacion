public class Empleado {
    private int  ID;
    private String nombre;

    public Empleado(int  ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public Empleado() {
        this.ID = 0000;
        this.nombre = "Desconocido";
    }

    public Empleado(int  ID) {
        this.ID = ID;
        this.nombre = "Desconocido";
    }   

    public Empleado(String nombre) {
        this.ID = 0000;
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
