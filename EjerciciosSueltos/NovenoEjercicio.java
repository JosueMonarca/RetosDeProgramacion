/*
 * EJERCICIO:
 * Explora el concepto de herencia según tu lenguaje. Crea un ejemplo que
 * implemente una superclase Animal y un par de subclases Perro y Gato,
 * junto con una función que sirva para imprimir el sonido que emite cada Animal.
 *
 * DIFICULTAD EXTRA (opcional):
 * Implementa la jerarquía de una empresa de desarrollo formada por Empleados que
 * pueden ser Gerentes, Gerentes de Proyectos o Programadores.
 * Cada empleado tiene un identificador y un nombre.
 * Dependiendo de su labor, tienen propiedades y funciones exclusivas de su
 * actividad, y almacenan los empleados a su cargo.
 */
public class NovenoEjercicio {
    public static void main(String[] args) {
        // Ejercicio de herencia con animales
        EjercicioSonido();
        // Dificultad extra: jerarquía de empleados
        EjercicioEmpleados();
    }

    private static void EjercicioSonido(){
        Gato gato = new Gato("miguel");
        Perro perro = new Perro("Solovino");

        gato.hacerSonido();
        perro.hacerSonido();
    }

    private static void EjercicioEmpleados() {
        // Crear empleados
        Empleado empleado1 = new Empleado(1, "Juan");
        Empleado empleado2 = new Empleado(2, "Ana");

        // Crear gerente
        Gerente gerente = new Gerente(3, "Carlos", "IT", "Proyecto A");
        gerente.setEmpleadosACargo(new Empleado[]{empleado1, empleado2});

        // Crear programador
        Programador programador = new Programador(4, "Luis", "Java", "Proyecto B");

        // Crear gerente de proyecto
        GerenteDeProyecto gerenteDeProyecto = new GerenteDeProyecto(5, "María", "IT", "Proyecto C", "Spring");

        // Imprimir información
        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(gerente);
        System.out.println(programador);
        System.out.println(gerenteDeProyecto);
    }
}
