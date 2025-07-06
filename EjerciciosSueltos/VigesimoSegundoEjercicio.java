import java.util.Arrays;
import java.util.Date;
import java.util.Map;
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
public class VigesimoSegundoEjercicio {
    public static void main(String[] args) {
        Alumno[] alumnos = crearAlumnosAleatorios(10);
        nuevoAlumno("Juan Pérez", new Date(), Map.of("Matemáticas", 9.5, "Historia", 8.0));
        Alumno[] mejoresEstudiantes = obtenerMejoresEstudiantes(alumnos);
        Alumno[] ordenadosPorNacimiento = ordenarPorNacimiento(alumnos);
        double mayorCalificacion = obtenerMayorCalificacion(alumnos);
        System.out.println("Mejores estudiantes: " + Arrays.toString(mejoresEstudiantes));
        System.out.println("Estudiantes ordenados por fecha de nacimiento: " + Arrays.toString(ordenadosPorNacimiento));
        System.out.println("Mayor calificación: " + mayorCalificacion);

    }

private static Alumno nuevoAlumno(String nombre, Date fechaNacimiento, Map<String, Double> calificaciones) {
        Alumno alumno = new Alumno(nombre, fechaNacimiento, calificaciones);
        return alumno;
    }

    private static Alumno[] obtenerMejoresEstudiantes(Alumno[] alumnos){
        return Arrays.stream(alumnos)
                .filter(alumno -> alumno.getPromedioCalificaciones() >= 9)
                .toArray(Alumno[]::new);
    }

    private static Alumno[] ordenarPorNacimiento(Alumno[] alumnos){
        return Arrays.stream(alumnos).sorted((a1, a2) -> a1.getFechaNacimiento().compareTo(a2.getFechaNacimiento()))
                .toArray(Alumno[]::new);
    }

    private static double obtenerMayorCalificacion(Alumno[] alumnos){
        return Arrays.stream(alumnos)
                .flatMapToDouble(alumno -> alumno.getCalificaciones().values().stream().mapToDouble(Double::doubleValue))
                .max()
                .orElse(0);
    }

    private static Alumno[] crearAlumnosAleatorios(int cantidad){
        Alumno[] alumnos = new Alumno[cantidad];
        for (int i = 0; i < cantidad; i++) {
            String nombre = "Alumno " + (i + 1);
            long millisInYear = 365L * 24 * 60 * 60 * 1000;
            Date fechaNacimiento = new Date(System.currentTimeMillis() - (long)(Math.random() * 20 * millisInYear));
            Map<String, Double> calificaciones = Map.of("Matemáticas", Math.random() * 10, "Historia", Math.random() * 10);
            alumnos[i] = new Alumno(nombre, fechaNacimiento, calificaciones);
        }
        return alumnos;
    }
}
