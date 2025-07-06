import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class manejoJsonAndXml {
    
    public manejoJsonAndXml(){
        
    }

    public static void crearJson(){
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

    public static void crearJson(String name){
        try(FileWriter datosJSon = new FileWriter(name)){
            datosJSon.write ("""
                    {
                    }
                    """);
            System.out.println("Archivo JSON creado con éxito.");
        }catch (IOException e) {
            System.out.println("Error al crear el archivo JSON: " + e.getMessage());
        }
    }

    public static void crearJson(String name, String contenido){
        try(FileWriter datosJSon = new FileWriter(name)){
            datosJSon.write(contenido);
            System.out.println("Archivo JSON creado con éxito.");
            System.out.println("Contenido del archivo JSON:"+contenido);
        }catch (IOException e) {
            System.out.println("Error al crear el archivo JSON: " + e.getMessage());
        }
    }

    public static void crearXml(){
        try {
            // Crear documento XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Crear elemento raíz
            Element rootElement = doc.createElement("persona");
            doc.appendChild(rootElement);

            // Elementos hijos
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode("Josue"));
            rootElement.appendChild(nombre);

            Element edad = doc.createElement("edad");
            edad.appendChild(doc.createTextNode("18"));
            rootElement.appendChild(edad);

            Element lenguaje = doc.createElement("lenguaje");
            lenguaje.appendChild(doc.createTextNode("Java"));
            rootElement.appendChild(lenguaje);

            // Guardar en archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // identación bonita
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("datos.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML creado con éxito.");
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            System.out.println("Error de configuración del parser XML: " + e.getMessage());
        } catch (javax.xml.transform.TransformerException e) {
            System.out.println("Error al transformar el documento XML: " + e.getMessage());
        }
    }

    public static void crearXml(String name){
        try {
            // Crear documento XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Guardar en archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // identación bonita
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(name));
            transformer.transform(source, result);
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            System.out.println("Error de configuración del parser XML: " + e.getMessage());
        }catch (TransformerConfigurationException e){
            System.out.println("Error de configuración del transformador XML: " + e.getMessage());
        } catch (javax.xml.transform.TransformerException e) {
            System.out.println("Error al transformar el documento XML: " + e.getMessage());
        }
    }

    public static void crearXml(String name, String contenido){
        //Crear documento XML
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Crear elemento raíz
            Element rootElement = doc.createElement("persona");
            doc.appendChild(rootElement);

            // Añadir contenido al XML
            Element contenidoElement = doc.createElement("contenido");
            contenidoElement.appendChild(doc.createTextNode(contenido));
            rootElement.appendChild(contenidoElement);

            // Guardar en archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // identación bonita
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(name));
            transformer.transform(source, result);

            System.out.println("Archivo XML creado con éxito.");
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            System.out.println("Error de configuración del parser XML: " + e.getMessage());
        } catch (javax.xml.transform.TransformerException e) {
            System.out.println("Error al transformar el documento XML: " + e.getMessage());
        }
    }

    public static void borrarArchivos() {
        borrarArchivos("datos.json");
        borrarArchivos("datos.xml");
    }

    public static void obtenerInformacion(String name) {
        File archivo = new File(name);
        
        if (archivo.exists()) {
            System.out.println("Nombre del archivo: " + archivo.getName());
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Tamaño: " + archivo.length() + " bytes");
            System.out.println("¿Es un directorio? " + archivo.isDirectory());
            System.out.println("¿Es un archivo? " + archivo.isFile());
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public static void borrarArchivos(String name) {
        File jsonFile = new File(name);
        
        String mensaje = jsonFile.delete()? "Archivo borrado con éxito." : "Error al borrar el archivo.";
        System.out.println(mensaje);
    }

    public static Object parse(String json) { 
        File jsonFile = new File(json);
        if(!jsonFile.equals(jsonFile)){
            System.out.println("El archivo no existe o no es un archivo JSON válido.");
            return null;
        }else{
            try(BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea);
                }
                return asObject(contenido.toString());
            } catch (IOException e) {
                System.out.println("Error al leer el archivo JSON: " + e.getMessage());
                return null;
            }
        }
        
    }

    public static Map<String, Object> asObject(String json) { return null;}

    //public static List<Object> asArray(String json) { }

    //public static String toJson(Object value) { }

    //public static boolean isValidJson(String json) {}

    public static String readJsonFile(String path) { 
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
        return contenido.toString();
    }

    public static void writeJsonFile(String path, String json) { }
}
