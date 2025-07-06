import java.util.Date;

public class Evento {
    private String nombre;
    private Date fecha;
    private String lugar;
    private String ID;

    //Constructores
    public Evento(){
        this.nombre = "";
        this.fecha = new Date();
        this.lugar = "";
        this.ID = "";
    }

    public Evento(String nombre, Date fecha, String lugar, String ID){
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.ID = ID;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    
}
