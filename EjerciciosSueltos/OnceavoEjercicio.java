import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
 * IMPORTANTE: Sólo debes subir el fichero de código como parte del ejercicio.
 *
 * EJERCICIO:
 * Desarrolla un programa capaz de crear un archivo que se llame como
 * tu usuario de GitHub y tenga la extensión .txt.
 * Añade varias líneas en ese fichero:
 * - Tu nombre.
 * - Edad.
 * - Lenguaje de programación favorito.
 * Imprime el contenido.
 * Borra el fichero.
 *
 * DIFICULTAD EXTRA (opcional):
 * Desarrolla un programa de gestión de ventas que almacena sus datos en un 
 * archivo .txt.
 * - Cada producto se guarda en una línea del archivo de la siguiente manera:
 *   [nombre_producto], [cantidad_vendida], [precio].
 * - Siguiendo ese formato, y mediante terminal, debe permitir añadir, consultar,
 *   actualizar, eliminar productos y salir.
 * - También debe poseer opciones para calcular la venta total y por producto.
 * - La opción salir borra el .txt.
 */
public class OnceavoEjercicio {
    public static void main(String[] args) {
        borrarArchivo();
        crearArchivo();
    }

    private static void crearArchivo(){
        try (FileWriter Archivo = new FileWriter("JosueMonarca.txt")) {
            Archivo.write("Nombre: Josue Monarca\n");
            Archivo.write("Edad: 18\n");
            Archivo.write("Lenguaje de programación favorito: Java\n");

            System.out.println("Archivo creado con éxito.");
        } catch (IOException e) {
            System.out.println("Se ha producido un error al crear el archivo: " + e.getMessage());
        }
            
    }

    private static void borrarArchivo(){
        File archivo = new File("./JosueMonarca.txt");

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo borrado con éxito.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
