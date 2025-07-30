
package ejercicio.cuadragesimo;

public interface IPost {
    public void setPost(String post);
    public String getPost();
    public String getId();
    public int getNumLikes();
    public void addLike(String idUsuario);
    public void removeLike(String idUsuario);
    public String getDateOfCreation();
}
