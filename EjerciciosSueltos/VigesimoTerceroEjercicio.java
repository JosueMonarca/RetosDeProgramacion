/*
 * EJERCICIO:
 * Explora el patrón de diseño "singleton" y muestra cómo crearlo
 * con un ejemplo genérico.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utiliza el patrón de diseño "singleton" para representar una clase que
 * haga referencia a la sesión de usuario de una aplicación ficticia.
 * La sesión debe permitir asignar un usuario (id, username, nombre y email),
 * recuperar los datos del usuario y borrar los datos de la sesión.
 */
public class VigesimoTerceroEjercicio {
    public static void main(String[] args){
        Sesion sesion = Sesion.getSesion();
        sesion.setUsuario("Juan Perez");
        sesion.setIdUsuario("12345");
        sesion.setIsSesion(true);
        System.out.println("Usuario: " + sesion.getUsuario());
        System.out.println("ID Usuario: " + sesion.getIdUsuario());
        System.out.println("Sesión activa: " + sesion.getIsSesion());
        // Simulando el cierre de sesión
        sesion.setIsSesion(false);
        System.out.println("Sesión activa después de cerrar: " + sesion.getIsSesion
());
        // Limpiando los datos de la sesión
        sesion.setUsuario(null);
        sesion.setIdUsuario(null);
        System.out.println("Usuario después de limpiar: " + sesion.getUsuario());
        System.out.println("ID Usuario después de limpiar: " + sesion.getIdUsuario());
        System.out.println("Sesión activa después de limpiar: " + sesion.getIsSesion());
    }
}
