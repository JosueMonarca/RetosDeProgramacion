package ejercicio.cuadragesimo;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario("Alice", "1");
        user.addPost("Hello, world!");
        user.addPost("Java is great!");

        System.out.println("User: " + user.getName());
        System.out.println("Number of posts: " + user.getNumPosts());

        for (int i = 0; i < user.getNumPosts(); i++) {
            System.out.println("Post " + (i + 1) + ": " + user.getPost(i));
        }

        Usuario user2 = new Usuario("Josue", "2");
        user2.addPost("Learning Java interfaces!");
        user2.addLike("1"); // User 2 likes User 1's post

        System.out.println("User 2: " + user2.getName());
        System.out.println("User 2's first post: " + user2.getPost(0));
        System.out.println("User 1's post likes: " + BaseDeDatosSocial.getPost("1").getNumLikes());

        user2.setFollower("1"); // User 2 follows User 1
        System.out.println("User 2's followers count: " + user2.getNumFollowers());

        user.showFeed(); // Display User 1's feed
        user2.showFeed(); // Display User 2's feed

        user.showFeedSeguidos(); // Display User 1's followed users' feed
        user2.showFeedSeguidos(); // Display User 2's followed users' feed
    }
}
