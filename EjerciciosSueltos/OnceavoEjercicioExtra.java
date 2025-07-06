/*
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

/**
 *
 * @author jmona
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnceavoEjercicioExtra {

    public static void main (String[] args) {
        crearArchivo();
        boolean seguir = true;

        try (Scanner scanner = new Scanner(System.in)) {

            while (seguir){
                mostrarMenu();
                int opcion ;
                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    continue;
                }
                switch (opcion) {
                    case 1 -> agregarProducto(scanner);
                    case 2 -> consultarProducto(scanner);
                    case 3 -> actualizarProducto(scanner);
                    case 4 -> eliminarProducto(scanner);
                    case 5 -> calcularVentaTotal();
                    case 6 -> calcularVentaPorProducto(scanner);
                    case 7 -> imprimirInventario();
                    case 8 -> {
                        borrarArchivo();
                        seguir = false;
                    }
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            }

        }

    }

    private static void crearArchivo(){
        try( FileWriter archivoVentas = new FileWriter("ventas.txt")){
            archivoVentas.write("Producto1 , 10 , 20.5 \n");
            archivoVentas.write("Producto2 , 5 , 15.0 \n");
            archivoVentas.write("Producto3 , 2 , 30.0 \n");
            System.out.println("Archivo creado con éxito.");
        } catch (IOException e) {
            System.out.println("Se ha producido un error al crear el archivo: " + e.getMessage());
        }
    }

    private static void mostrarMenu(){
        System.out.println("----- Menú de Gestión de Ventas -----");
        System.out.println("1. Agregar producto");
        System.out.println("2. Consultar producto");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Calcular venta total");
        System.out.println("6. Calcular venta por producto");
        System.out.println("7. Imprimir inventario");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");

    }

    private static void agregarProducto( Scanner sc){
        try(FileWriter archivoVentas = new FileWriter("ventas.txt", true)){//Usa true si quieres conservar lo que ya hay en el archivo y solo agregar al final.
            System.out.println("Por favor ingrese el producto a agregar");               //Usa false si quieres empezar desde cero y borrar lo anterior.
            String producto = sc.nextLine();

            System.out.println("Ingrese por favor la cantidad vendida ");
            int cantidad = sc.nextInt();

            System.out.println("Ingrese por favor el precio");
            double precio = sc.nextDouble();
            
            String linea = producto+" , "+ String.valueOf(cantidad)+" , "+String.valueOf(precio);

            archivoVentas.write(linea);

        } catch(IOException e){
            System.out.println("No se pudo encontrar o crear el archivo ventas.txt: " + e.getMessage());
        }
    }

    private static void consultarProducto(Scanner sc){
        System.out.println("Por favor ingrese el nombre del producto a consultar:");
        String producto = sc.nextLine();
        boolean encontrado = false;

        try (BufferedReader lector = new BufferedReader(new FileReader("./ventas.txt"))) {
            String linea;
            ArrayList <String> productos = new ArrayList<>();

            while ((linea = lector.readLine()) != null) {
                productos.add(linea);
            }

            String tabla[][] = new String[productos.size()][];

            for (int i = 0; i < productos.size(); i++) {
                tabla[i] = productos.get(i).split(" , ");
            }
            
            for (String[] fila : tabla) {
                if(fila[0].equalsIgnoreCase(producto)){
                    System.out.println("Producto encontrado: " + fila[0]);
                    System.out.println("Cantidad vendida: " + fila[1]);
                    System.out.println("Precio: " + fila[2]);
                    encontrado = true;
                    break; // Salir del bucle si se encuentra el producto
                }
            }

            if(!encontrado) {
                System.out.println("Producto no encontrado.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void actualizarProducto(Scanner sc){
        double nuevoPrecio = -1;
        int nuevaCantidad = -1;
        boolean encontrado = false;

        System.out.println("Por favor ingrese el nombre del producto a actualizar:");
        String producto = sc.nextLine();

        System.out.println("Ingrese el nuevo nombre del producto (dejar en blanco si no desea cambiarlo):");
        String nuevoNombre = sc.nextLine();
        if (nuevoNombre.isEmpty()) {
            nuevoNombre = producto; // Actualizar el nombre del producto si se proporciona uno nuevo
        }
        
        sc.nextLine(); // Limpiar el buffer del scanner después de leer el nombre
        System.out.println("¿Desea actualizar el precio? (Si/No)");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.println("Ingrese el nuevo precio:");
            nuevoPrecio = sc.nextDouble();
        }

        sc.nextLine(); // Limpiar el buffer del scanner después de leer el double
        System.out.println("¿Desea actualizar la cantidad vendida? (Si/No)");
        String newrespuesta = sc.nextLine();
        if (newrespuesta.equalsIgnoreCase("Si")) {
            System.out.println("Ingrese la nueva cantidad vendida:");
            nuevaCantidad = sc.nextInt();
        }
        

        try (BufferedReader lector = new BufferedReader(new FileReader("./ventas.txt"))) {
            String linea;
            ArrayList <String> productos = new ArrayList<>();

            while ((linea = lector.readLine()) != null) {
                productos.add(linea);
            }

            String tabla[][] = new String[productos.size()][];

            for (int i = 0; i < productos.size(); i++) {
                tabla[i] = productos.get(i).split(" , ");
            }
            
            for (int i = 0; i < tabla.length; i++) {
                if(tabla[i][0].equalsIgnoreCase(producto)){
                    tabla[i][0] = nuevoNombre; // Mantener el nombre del producto
                    tabla[i][1] = (nuevaCantidad > -1) ? String.valueOf(nuevaCantidad) : tabla[i][1]; // Actualizar cantidad si se proporcionó
                    tabla[i][2] = (nuevoPrecio > -1) ? String.valueOf(nuevoPrecio) : tabla[i][2]; // Actualizar precio si se proporcionó
                    encontrado = true;
                    break; // Salir del bucle si se encuentra el producto
                }
            }

            if(!encontrado) {
                System.out.println("Producto no encontrado.");
            }else{
                // Escribir los cambios de vuelta al archivo 
                try(FileWriter archivoVentas = new FileWriter("./ventas.txt")){
                    for (String[] fila : tabla) {
                        archivoVentas.write(String.join(" , ", fila) + "\n");
                    }
                    System.out.println("Producto actualizado con éxito.");
                } catch(IOException e){
                    System.out.println("No se pudo actualizar el archivo ventas.txt: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void eliminarProducto(Scanner sc){
        boolean encontrado = false;

        System.out.println("Por favor ingrese el nombre del producto a eliminar:");
        String producto = sc.nextLine();
        
        try (BufferedReader lector = new BufferedReader(new FileReader("./ventas.txt"))) {
            String linea;
            ArrayList <String> productos = new ArrayList<>();

            while ((linea = lector.readLine()) != null) {
                productos.add(linea);
            }

            String tabla[][] = new String[productos.size()][];

            for (int i = 0; i < productos.size(); i++) {
                tabla[i] = productos.get(i).split(" , ");
            }
            
            String[][] nuevaTabla = new String[tabla.length - 1][];
            // Buscar el producto en la tabla
            for (int i = 0; i < tabla.length; i++) {
                if(tabla[i][0].equalsIgnoreCase(producto)){
                    // Eliminar el producto de la tabla
                    encontrado = true;
                    continue; // Saltar al siguiente producto
                }else{
                    // Eliminar el producto de la tabla
                    nuevaTabla[i - (encontrado ? 1 : 0)] = tabla[i];
                }
            }

            if(!encontrado) {
                System.out.println("Producto no encontrado.");
            }else{
                // Escribir los cambios de vuelta al archivo 
                try(FileWriter archivoVentas = new FileWriter("./ventas.txt")){
                    for (String[] fila : nuevaTabla) {
                        archivoVentas.write(String.join(" , ", fila) + "\n");
                    }
                    System.out.println("Producto actualizado con éxito.");
                } catch(IOException e){
                    System.out.println("No se pudo actualizar el archivo ventas.txt: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    private static void calcularVentaTotal(){
        double total = 0.0;

        try (BufferedReader Lector = new BufferedReader(new FileReader("./ventas.txt"))){
            String Linea;

            while ((Linea = Lector.readLine()) != null) {
                String[] partes = Linea.split(" , ");
                if (partes.length == 3) {
                    try {
                        int cantidad = Integer.parseInt(partes[1].trim());
                        double precio = Double.parseDouble(partes[2].trim());
                        total += cantidad * precio;
                    } catch (NumberFormatException e) {
                        System.out.println("Error al procesar la línea: " + Linea);
                    }
                }
            }
            System.out.println("La venta total es: " + total);
        }catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void calcularVentaPorProducto(Scanner sc){
        boolean encontrado = false;
        double total = 0.0;

        System.out.println("Por favor ingrese el nombre del producto a sacar el total:");
        String producto = sc.nextLine();

        try (BufferedReader lector = new BufferedReader(new FileReader("./ventas.txt"))) {
            String linea;
            ArrayList <String> productos = new ArrayList<>();

            while ((linea = lector.readLine()) != null) {
                productos.add(linea);
            }

            String tabla[][] = new String[productos.size()][];

            for (int i = 0; i < productos.size(); i++) {
                tabla[i] = productos.get(i).split(" , ");
            }
            
            for (int i = 0; i < tabla.length; i++) {
                if(tabla[i][0].equalsIgnoreCase(producto)){
                    try {
                        int cantidad = Integer.parseInt(tabla[i][1].trim());
                        double precio = Double.parseDouble(tabla[i][2].trim());
                        total += cantidad * precio;
                    } catch (NumberFormatException e) {
                        System.out.println("Error al procesar la línea: " + productos.get(i));
                    }
                    System.out.println("Producto encontrado: " + tabla[i][0]);
                    System.out.println("Cantidad vendida: " + tabla[i][1]);
                    System.out.println("Precio: " + tabla[i][2]);
                    System.out.println("Total de ventas para " + tabla[i][0] + ": " + total);
                    encontrado = true;
                    break; // Salir del bucle si se encuentra el producto
                }
            }

            if(!encontrado) {
                System.out.println("Producto no encontrado.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void borrarArchivo() {
        File archivo = new File("./ventas.txt");

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

    private static void imprimirInventario() {
        try (BufferedReader lector = new BufferedReader(new FileReader("./ventas.txt"))) {
            String linea;
            System.out.println("----- Inventario de Productos -----");
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
