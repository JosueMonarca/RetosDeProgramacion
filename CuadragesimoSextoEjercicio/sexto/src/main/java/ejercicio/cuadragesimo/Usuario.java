package ejercicio.cuadragesimo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Usuario implements IUsuario {
    private String name;
    private final String id;
    private final List<String> posts;
    private final List<String> followers;

    public Usuario(String name, String id) {
        this.name = name;
        this.id = id;
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    @Override
    public void addPost(String post) {
        posts.add(post);
        BaseDeDatosSocial.registrarPost(new Post(post, id)); // Assuming Post constructor takes post content and user ID
    }

    @Override
    public void addLike(String IdPost) {
        Post post = BaseDeDatosSocial.getPost(IdPost);
        if (post != null) {
            post.addLike(id);
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getPost(int index) {
        if (index >= 0 && index < posts.size()) {
            return posts.get(index);
        }
        return null;
    }

    @Override
    public int getNumPosts() {
        return posts.size();
    }

    @Override
    public int setFollower(String idFollower) {
        if (!followers.contains(idFollower)) {
            followers.add(idFollower);
            return followers.size(); // Return the new number of followers
        }
        return -1; // Follower already exists
    }

    @Override
    public int getNumFollowers() {
        return followers.size();
    }

    @Override
    public void showFeed() {
        System.out.println("Feed for " + name + ":");
        for (String post : posts) {
            System.out.println("- " + post);
        }
        if (posts.isEmpty()) {
            System.out.println("No posts available.");
        }
    }
    public void showFeedSeguidos() {
    System.out.println("Feed de seguidos para " + name + ":");
    List<Post> feed = new ArrayList<>();

    for (String idSeguido : followers) {
        Usuario u = BaseDeDatosSocial.getUsuario(idSeguido);
        if (u != null) {
            for (String idPost : u.posts) {
                Post p = BaseDeDatosSocial.getPost(idPost);
                if (p != null) feed.add(p);
            }
        }
    }

    feed.sort(Comparator.comparing(Post::getDateOfCreation).reversed());
    feed.stream().limit(10).forEach(p -> {
        System.out.println("- " + p.getPost() + " [" + p.getDateOfCreation() + "]");
    });
}

}
