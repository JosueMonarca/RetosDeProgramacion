package ejercicio.cuadragesimo;

public interface IUsuario {
    public void addPost(String post);
    public void addLike(String IdPost);
    public void setName(String name);
    public String getName();
    public String getId();
    public String getPost(int index);
    public int getNumPosts();
    public int setFollower(String idFollower);
    public int getNumFollowers();
    public void showFeed();
}
