import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * IMPORTANTE: Sólo debes subir el fichero de código como parte del ejercicio.
 *
 * EJERCICIO:
 * Desarrolla un programa capaz de crear un archivo XML y JSON que guarde los
 * siguientes datos (haciendo uso de la sintaxis correcta en cada caso):
 * - Nombre
 * - Edad
 * - Fecha de nacimiento
 * - Listado de lenguajes de programación
 * Muestra el contenido de los archivos.
 * Borra los archivos.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utilizando la lógica de creación de los archivos anteriores, crea un
 * programa capaz de leer y transformar en una misma clase custom de tu 
 * lenguaje los datos almacenados en el XML y el JSON.
 * Borra los archivos.
 */

public class DoceavoEjercicio {
    public static void main(String[] args) {
        crearJson();
        crearXml();
        borrarArchivos();
    }

    private static void crearJson(){
        String contenido = """
            {
            "nombre": "Josue",
            "edad": 18,
            "fechaNAcimiento" : "2006-06-19",
            "lenguajes": [
                "Java",
                "JavaScript",
                "Python"
            ]
            }
            """;

        try(FileWriter datosJSon = new FileWriter("datos.json")){
            datosJSon.write(contenido);
            System.out.println("Archivo JSON creado con éxito.");
            System.out.println("Contenido del archivo JSON:"+contenido);
        }catch (IOException e) {
            System.out.println("Error al crear el archivo JSON: " + e.getMessage());
        }
    }

    private static void crearXml(){
        String contenido = """
                <?xml version="1.0" encoding="UTF-8"?>
                <persona>
                    <nombre>Josue</nombre>
                    <edad>18</edad>
                    <fechaNacimiento>2006-06-19</fechaNacimiento>
                    <Lenguajes>
                        <Lenguaje>Java</Lenguaje>
                        <Lenguaje>JavaScript</Lenguaje>
                        <Lenguaje>Python</Lenguaje>
                    </Lenguajes>
                </persona>
                """;
        
                try(FileWriter datosXml = new FileWriter("datos.xml")){
                    datosXml.write(contenido);
                    System.out.println("Archivo XML creado con éxito.");
                    System.out.println("Contenido del archivo XML:" + contenido);
                }catch (IOException e) {
                    System.out.println("Error al crear el archivo XML: " + e.getMessage());
                }
    }

    private static void borrarArchivos(){
        File jsonFile = new File("datos.json");
        File xmlFile = new File("datos.xml");

        String mensaje = jsonFile.delete()? "Archivo JSON borrado con éxito." : "Error al borrar el archivo JSON.";
        System.out.println(mensaje);

        mensaje = xmlFile.delete()? "Archivo XML borrado con éxito." : "Error al borrar el archivo XML.";
        System.out.println(mensaje);
    }
}