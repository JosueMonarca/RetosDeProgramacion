package ejercicio.cuadragesimo;
import java.util.HashMap;
import java.util.Map;
public class BaseDeDatosSocial {

    private static final Map<String, Usuario> usuarios = new HashMap<>();
    private static final Map<String, Post> posts = new HashMap<>();

    // Registrar un nuevo usuario
    public static boolean registrarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getId())) {
            return false; // Ya existe
        }
        usuarios.put(usuario.getId(), usuario);
        return true;
    }

    // Obtener usuario por ID
    public static Usuario getUsuario(String id) {
        return usuarios.get(id);
    }

    // Registrar un nuevo post
    public static boolean registrarPost(Post post) {
        if (posts.containsKey(post.getId())) {
            return false; // Ya existe
        }
        posts.put(post.getId(), post);
        return true;
    }

    // Obtener post por ID
    public static Post getPost(String id) {
        return posts.get(id);
    }

    // Eliminar post
    public static boolean eliminarPost(String id) {
        return posts.remove(id) != null;
    }

    // Verificar existencia
    public static boolean existeUsuario(String id) {
        return usuarios.containsKey(id);
    }

    public static boolean existePost(String id) {
        return posts.containsKey(id);
    }
}
