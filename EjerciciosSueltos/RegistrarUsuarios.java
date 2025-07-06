import java.util.Scanner;

public class RegistrarUsuarios {

    public RegistrarUsuarios(){
    }

    public static Usuario registrartUsuario(Scanner scanner){
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
}