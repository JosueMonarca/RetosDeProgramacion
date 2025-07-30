package ejercicio.cuadragesimo;

import java.util.ArrayList;
import java.util.List;

public class Post implements IPost {
    private String post;
    private final String id;
    private final List<String> likes;
    private final String dateOfCreation;

    public Post(String post, String id) {
        this.post = post;
        this.id = id;
        this.likes = new ArrayList<>();
        this.dateOfCreation = java.time.LocalDate.now().toString();
    }

    @Override
    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String getPost() {
        return post;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getNumLikes() {
        return likes.size();
    }

    @Override
    public void addLike(String idUsuario) {
        likes.add(idUsuario);
    }

    @Override
    public void removeLike(String idUsuario) {
        likes.remove(idUsuario); // Remove the last like for simplicity
        // In a real application, you would check if the idUsuario exists in likes
        // and remove it specifically.
    }

    @Override
    public String getDateOfCreation() {
        return dateOfCreation;
    }

}
