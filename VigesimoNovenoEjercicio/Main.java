/*
 * EJERCICIO:
 * Explora el "Principio SOLID de Segregación de Interfaces
 * (Interface Segregation Principle, ISP)", y crea un ejemplo
 * simple donde se muestre su funcionamiento de forma correcta e incorrecta.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un gestor de impresoras.
 * Requisitos:
 * 1. Algunas impresoras sólo imprimen en blanco y negro.
 * 2. Otras sólo a color.
 * 3. Otras son multifunción, pueden imprimir, escanear y enviar fax.
 * Instrucciones:
 * 1. Implementa el sistema, con los diferentes tipos de impresoras y funciones.
 * 2. Aplica el ISP a la implementación.
 * 3. Desarrolla un código que compruebe que se cumple el principio.
 */
public class Main {
    public static void main(String[] args) {
        ImpresoraBlacoNegro impre = new ImpresoraBlacoNegro();
        impre.imprimirBlancoNegro("Buenos dias", 0);

        ImprimirColor impr = new ImpresoraColor();
        impr.imprimirColor("Buenos dias", "cyan", 1);
        impr.imprimirColor("Buenos dias", "red", 1);
        impr.imprimirColor("Buenos dias", "green", 1);
        impr.imprimirColor("Buenos dias", "yellow", 1);
        impr.imprimirColor("Buenos dias", "purple", 1);
        impr.imprimirColor("Buenos dias", "blue", 1);
        impr.imprimirColor("Buenos dias", "white", 1);
        impr.imprimirColor("Buenos dias", "black", 1);
        impr.imprimirColor("Buenos dias", "pink", 1);
        impr.imprimirColor("Buenos dias", "reset", 1);

        EnviarRecivirFax fax = new ImpresoraTodo();
        fax.enviarFax("12345", "doucumento de prueva");
        System.out.println(fax.recibirFax("12345"));
    }
}
