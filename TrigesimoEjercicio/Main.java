/*
 * EJERCICIO:
 * Explora el "Principio SOLID de Inversión de Dependencias (Dependency Inversion
 * Principle, DIP)" y crea un ejemplo simple donde se muestre su funcionamiento 
 * de forma correcta e incorrecta.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un sistema de notificaciones.
 * Requisitos:
 * 1. El sistema puede enviar Email, PUSH y SMS (implementaciones específicas).
 * 2. El sistema de notificaciones no puede depender de las implementaciones específicas.
 * Instrucciones:
 * 1. Crea la interfaz o clase abstracta.
 * 2. Desarrolla las implementaciones específicas.
 * 3. Crea el sistema de notificaciones usando el DIP.
 * 4. Desarrolla un código que compruebe que se cumple el principio.
 */
public class Main {
    public static void main(String[] args) {
        // Crear los objetos de notificacion
        Notification sms = new SMS();
        Notification push = new PUSH();
        Notification email = new Email();
        
        //Enviar mensajes
        sms.send("Hola me llamo Josue");
        push.send("Que honda");
        email.send("Nice");

        // Ahora se pasan como parametros
        SendMessage send = new SendMessage(email);
        send.print("Hola mundo");
        send = new SendMessage(sms);
        send.print("Hola Josue");
        send = new SendMessage(push);
        send.print("Hola Push");
        

        // Imprimir el tipo de notificacion
        System.out.println("Tipo de notificacion: " + send.getType());
        System.out.println("Tipo de notificacion: " + sms.getType());
        System.out.println("Tipo de notificacion: "+ push.getType());
        System.out.println("Tipo de notificacion: "+ email.getType());
    }
}
