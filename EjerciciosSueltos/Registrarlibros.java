import java.util.Scanner;

public class Registrarlibros {

    public Registrarlibros() {
    }

    public static Libro registraLibro(Scanner scanner){
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

}
