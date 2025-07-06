public class Libro {
    private String titulo;
    private String autor;
    private int copiasDisponibles = 10; // Valor por defecto
    private String ISBN;// Identificador único del libro
    private String genero;// Género del libro

    // CONSTRUCTORES
    public Libro() {
        titulo = "";
        autor = "";
        copiasDisponibles = 0;
        ISBN = "";
        genero = "";
    }

    public Libro(String titulo, String autor, int copiasDisponibles, String ISBN, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.copiasDisponibles = copiasDisponibles;
        this.ISBN = ISBN;
        this.genero = genero;
    }

    // GETTERS Y SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", copiasDisponibles=" + copiasDisponibles +
                ", ISBN='" + ISBN + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
