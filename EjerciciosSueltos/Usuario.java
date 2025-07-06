public class Usuario {
    private String nombre;
    private int edad;
    private String foto;
    private String direccion;
    private String ID;
    private String email;

    //CONSTRUCTORES
    public Usuario(){
        nombre = "";
        edad  = 0;
        foto = "";
        direccion = "";
        ID = "0";
        email = "ejemplo@a.com";
    }

    public Usuario(String nombre, int edad, String foto, String direccion, String ID, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.direccion = direccion;
        this.ID = ID;
        this.email = email;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", foto='" + foto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ID='" + ID + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
