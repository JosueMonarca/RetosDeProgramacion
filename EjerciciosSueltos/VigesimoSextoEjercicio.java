
import java.util.Scanner;

/*
 * EJERCICIO:
 * Explora el "Principio SOLID de Responsabilidad Única (Single Responsibility
 * Principle, SRP)" y crea un ejemplo simple donde se muestre su funcionamiento
 * de forma correcta e incorrecta.
 *
 * DIFICULTAD EXTRA (opcional):
 * Desarrolla un sistema de gestión para una biblioteca. El sistema necesita
 * manejar diferentes aspectos como el registro de libros, la gestión de usuarios
 * y el procesamiento de préstamos de libros.
 * Requisitos:
 * 1. Registrar libros: El sistema debe permitir agregar nuevos libros con
 * información básica como título, autor y número de copias disponibles.
 * 2. Registrar usuarios: El sistema debe permitir agregar nuevos usuarios con
 * información básica como nombre, número de identificación y correo electrónico.
 * 3. Procesar préstamos de libros: El sistema debe permitir a los usuarios
 * tomar prestados y devolver libros.
 * Instrucciones:
 * 1. Diseña una clase que no cumple el SRP: Crea una clase Library que maneje
 * los tres aspectos mencionados anteriormente (registro de libros, registro de
 * usuarios y procesamiento de préstamos).
 * 2. Refactoriza el código: Separa las responsabilidades en diferentes clases
 * siguiendo el Principio de Responsabilidad Única.
 */
public class VigesimoSextoEjercicio {
    static Libreria libreria = new Libreria();

    public static void main(String[] args) {
        boolean seguir = true;
        Scanner scanner = new Scanner(System.in);

        while (seguir){
            menu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 ->{
                    libreria.registrarLibro(registraLibro(scanner));
                    break;
                }
                case 2 ->{
                    libreria.registrarUsuario(registrartUsuario(scanner));
                    break;
                }
                case 3 -> {
                    libreria.prestarLibro(registraLibro(scanner), registrartUsuario(scanner));
                    break;
                }
                case 4 -> {
                    libreria.removePrestamo(devolverLibro(scanner));
                    break;
                }
                case 5 -> {
                    seguir = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> {
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                }
            }
        }
        
    }

    private static void menu(){
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar usuario");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Salir");
    }

    private static Libro registraLibro(Scanner scanner){
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Autor: ");
        String autor = scanner.nextLine();
        System.out.println("copias disponibles: ");
        int copiasDisponibles = scanner.nextInt();
        System.out.println("ISBN: ");
        String ISBN = scanner.next();
        System.out.println("Género: ");
        String genero = scanner.next();
        Libro libro = new Libro(titulo, autor, copiasDisponibles, ISBN, genero);
        return libro;
    }

    private static Usuario registrartUsuario(Scanner scanner){
        System.out.println("Nombre : ");
        String nombre = scanner.nextLine();

        System.out.println("Edad : ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Correo electrónico : ");
        String correo = scanner.nextLine();

        System.out.println("Direccion de la foto :");
        String foto = scanner.nextLine();

        System.out.println("Direccion :");
        String direccion  = scanner.nextLine();

        System.out.println("ID :");
        String id = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, edad, foto, direccion, id, correo);
        return usuario;
    }

    private static Prestamo devolverLibro(Scanner scanner){
        System.out.println("ingrese el ID del usuario: ");
        String idUsuario = scanner.nextLine();
        Usuario usuario = libreria.getUsuario(idUsuario);

        

        if(usuario != null){
            System.out.println("Ingrese el ISBN del libro:");
            String isbn = scanner.nextLine();
            Libro libro = libreria.getLibro(isbn);

            if(libro != null){
                return new Prestamo(usuario, libro);
            }else{
                return null;
            }
        }else {
            return null;
        }
    }
}
