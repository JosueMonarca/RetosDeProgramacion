public class Participante {
    private String nombre;
    private String ID;
    private String pais;
    
    //Constructores
    public Participante() {
        this.nombre = "";
        this.ID = "";
        this.pais = "";
    }

    public Participante(String nombre, String ID, String pais) {
        this.nombre = nombre;
        this.ID = ID;
        this.pais = pais;
    }

    //Getters y Setters
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
