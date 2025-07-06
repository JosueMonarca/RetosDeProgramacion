/*
 * EJERCICIO:
 * Explora el concepto de funciones de orden superior en tu lenguaje 
 * creando ejemplos simples (a tu elección) que muestren su funcionamiento.
 *
 * DIFICULTAD EXTRA (opcional):
 * Dada una lista de estudiantes (con sus nombres, fecha de nacimiento y 
 * lista de calificaciones), utiliza funciones de orden superior para
 * realizar las siguientes operaciones de procesamiento y análisis:
 * - Promedio calificaciones: Obtiene una lista de estudiantes por nombre
 *   y promedio de sus calificaciones.
 * - Mejores estudiantes: Obtiene una lista con el nombre de los estudiantes
 *   que tienen calificaciones con un 9 o más de promedio.
 * - Nacimiento: Obtiene una lista de estudiantes ordenada desde el más joven.
 * - Mayor calificación: Obtiene la calificación más alta de entre todas las
 *   de los alumnos.
 * - Una calificación debe estar comprendida entre 0 y 10 (admite decimales).
 */
import java.util.Date;
import java.util.Map;
public class Alumno {
    private String nombre;
    private Date fechaNacimiento;
    private Map <String, Double> calificaciones;

    public Alumno ( String nombre, Date fechaDeNacimiento, Map <String, Double> calificaciones){
        this.nombre = nombre;
        this.fechaNacimiento = fechaDeNacimiento;
        this.calificaciones = calificaciones;
    }

    //GETTERS AND SETTERS
    public String getNombre(){
        return nombre;
    }

    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }

    public Map <String, Double> getCalificaciones(){
        return calificaciones;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCalificaciones(Map <String, Double> calificaciones){
        this.calificaciones = calificaciones;
    }

    public double getPromedioCalificaciones(){
        double suma = 0;
        for (double calificacion : calificaciones.values()){
            suma += calificacion;
        }
        return suma / calificaciones.size();
    }
    
}
