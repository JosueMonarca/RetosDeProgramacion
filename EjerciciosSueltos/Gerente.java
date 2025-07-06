public class Gerente extends Empleado {
    private String departamento;
    private String proyecto;
    private Empleado[] empleadosACargo;

    public Gerente(int id, String nombre, String departamento, String proyecto) {
        super(id, nombre);
        this.departamento = departamento;
        this.proyecto = proyecto;
    }

    public Empleado[] getEmpleadosACargo() {
        return empleadosACargo;
    }   

    public void setEmpleadosACargo(Empleado[] empleadosACargo) {
        this.empleadosACargo = empleadosACargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

}
