import java.util.ArrayList;

public class Libreria {
    private final ArrayList<Libro> libros;
    private final ArrayList<Usuario> usuarios;
    private final ArrayList <Prestamo> prestamos;
    
    public Libreria(){
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro libro){
        libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void prestarLibro(Libro libro,Usuario usuario){
        if(libros.contains(libro) && usuarios.contains(usuario)){
            prestamos.add(new Prestamo(usuario, libro));
        }else{
            System.out.println("Error no se encuentra al usuario o al libro");
        }
    }

    public boolean isPrestamo(Prestamo prestamoMap){
        return prestamos.contains(prestamoMap);
    }

    public Usuario getUsuario ( String idUsuario){
        for (Usuario usuario : usuarios) {
            if (usuario.getID().equals(idUsuario)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra el usuario
    }

    public Libro getLibro (String isbn){
        for (Libro libro : libros) {
            if (libro.getISBN().equals(isbn)) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro
    }

    public void removePrestamo(Prestamo prestamo){
        if(isPrestamo(prestamo)){
            prestamos.remove(prestamo);
        }else{
            
        }
    }

}  
