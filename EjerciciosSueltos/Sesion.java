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
public class Sesion {
    private static final Sesion instanciaSesion = new Sesion();
    private String Usuario;
    private String IdUsuario;
    private boolean isSesion;

    private Sesion(){}

    //GETTERS AND SETTERS
    public void setUsuario(String usuario){
        Usuario = usuario;
    }

    public String getUsuario(){
        return Usuario;
    }

    public void setIsSesion( boolean isSesion){
        this.isSesion = isSesion;
    }

    public boolean getIsSesion(){
        return isSesion;
    }

    public void setIdUsuario(String Id){
        this.IdUsuario = Id;
    }

    public String getIdUsuario(){
        return IdUsuario;
    }

    public static Sesion getSesion(){
        return Sesion.instanciaSesion;
    }
}
