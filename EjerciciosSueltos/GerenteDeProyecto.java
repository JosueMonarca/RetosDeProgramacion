public class GerenteDeProyecto extends Gerente {
    private String tecnologia;

    public GerenteDeProyecto(int id, String nombre, String departamento, String proyecto, String tecnologia) {
        super(id, nombre, departamento, proyecto);
        this.tecnologia = tecnologia;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    @Override
    public String toString() {
        return "GerenteDeProyecto{" +
                "id=" + getID() +
                ", nombre='" + getNombre() + '\'' +
                ", departamento='" + getDepartamento() + '\'' +
                ", proyecto='" + getProyecto() + '\'' +
                ", tecnologia='" + tecnologia + '\'' +
                '}';
    }
    
}
