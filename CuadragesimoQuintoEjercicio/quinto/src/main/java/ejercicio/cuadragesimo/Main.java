package ejercicio.cuadragesimo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del usuario");
            String usuario = scanner.nextLine();
            
            String username = usuario; // <- Cambia por el usuario que quieras
            String url = "https://api.github.com/users/" + username;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/vnd.github.v3+json")
                    .header("User-Agent", "Java-App") // GitHub requiere un User-Agent
                    .build();

            try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            GitHubUser user = gson.fromJson(response.body(),GitHubUser.class) ;

            System.out.println("Nombre: " + user.getName()
                    + "\nLogin: " + user.getLogin()
                    + "\nUbicación: " + user.getLocation()
                    + "\nBio: " + user.getBio()
                    + "\nSeguidores: " + user.getFollowers()
                    + "\nSiguiendo: " + user.getFollowing()
                    + "\nRepositorios públicos: " + user.getPublic_repos()
                    + "\nGists públicos: " + user.getPublic_gists());

            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        } catch (JsonSyntaxException e) {
            System.out.println(e.getMessage());
        }
    }
}