package com.ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        final String TWITCH_CLIENT_ID;
        final String TWITCH_ACCESS_TOKEN;
        ListOfStreams lista = new ListOfStreams();
        
        String filePath = ".env";

        String[] tokens = getTokens(filePath);

        TWITCH_CLIENT_ID = tokens[0];
        TWITCH_ACCESS_TOKEN = tokens[2];

        try {
            showRankingOfFollowers(lista,TWITCH_CLIENT_ID, TWITCH_ACCESS_TOKEN);
            
        } catch (Exception e) {
            System.out.println("error "+ e.getMessage());
        }
        try {
            showRankingOfDate(lista, TWITCH_CLIENT_ID, TWITCH_ACCESS_TOKEN);
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
    }

    private static String[] getTokens(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String linea;
            String[] token = new String[3];

            while((linea = br.readLine()) != null){
                token = linea.split(",");
            }

            return token;

        } catch (Exception e) {
            System.out.println("No se encuentra el archivo en la ruta especificada o no se pudo leer el archivo");
            return  null;
        }
    }

    private static String getIdOfStream(String name, String ClientId, String accessToken ) throws Exception{
        String url = "https://api.twitch.tv/helix/users?login="+name;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest builder = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .header("Authorization", "Bearer "+accessToken)
        .header("Client-Id", ClientId)
        .GET()
        .build();

        // 3. Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(builder, HttpResponse.BodyHandlers.ofString());

        // Usar Gson para parsear la respuesta
        Gson gson = new Gson();
        TwitchUserResponse userResponse = gson.fromJson(response.body(), TwitchUserResponse.class);

        //System.out.println(response);
    
        // Validar que haya al menos un usuario
        if (userResponse.data != null && !userResponse.data.isEmpty()) {
            return userResponse.data.get(0).getId();
        } else {
            System.out.println("No se encontró el usuario: " + name);
            return null;
        }
    }

        private static String getDateOfCreation(String name, String ClientId, String accessToken ) throws Exception{
        String url = "https://api.twitch.tv/helix/users?login="+name;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest builder = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .header("Authorization", "Bearer "+accessToken)
        .header("Client-Id", ClientId)
        .GET()
        .build();

        // 3. Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(builder, HttpResponse.BodyHandlers.ofString());

        // Usar Gson para parsear la respuesta
        Gson gson = new Gson();
        TwitchUserResponse userResponse = gson.fromJson(response.body(), TwitchUserResponse.class);

        //System.out.println(response);
    
        // Validar que haya al menos un usuario
        if (userResponse.data != null && !userResponse.data.isEmpty()) {
            return userResponse.data.get(0).getCreated_at();
        } else {
            System.out.println("No se encontró el usuario: " + name);
            return null;
        }
    }

    private static int getNumOfFollowers(String id, String ClientId, String accessToken) throws Exception{
        String url = "https://api.twitch.tv/helix/channels/followers?broadcaster_id="+id;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest builder = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .header("Authorization", "Bearer "+accessToken)
        .header("Client-Id", ClientId)
        .GET()
        .build();

        // 3. Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(builder, HttpResponse.BodyHandlers.ofString());

        // Usar Gson para parsear la respuesta
        Gson gson = new Gson();
        numeroDeSeguidores userResponse = gson.fromJson(response.body(), numeroDeSeguidores.class);

        //System.out.println(response);

        return userResponse.getTotal();
        
    }

    private static void showRankingOfFollowers(ListOfStreams lista,String ClientId,String accessToken) throws  Exception{
        String[] listOfIds = new String[lista.LISTOFSTREAMS.length];
        HashMap <String,Integer> listOfNumFollowers = new HashMap<>(); 
        for (int i = 0; i < lista.LISTOFSTREAMS.length; i++) {
            listOfIds[i] = getIdOfStream(lista.LISTOFSTREAMS[i], ClientId, accessToken);
        }

        for (int i = 0; i < lista.LISTOFSTREAMS.length; i++) {
            Integer followers = getNumOfFollowers(listOfIds[i], ClientId, accessToken);
            listOfNumFollowers.put(lista.LISTOFSTREAMS[i], followers);
        }

        listOfNumFollowers.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // orden descendente
        .forEach(entry -> 
            System.out.println(entry.getKey() + ": " + entry.getValue())
        );
    }

    private static void showRankingOfDate(ListOfStreams lista,String ClientId,String accessToken) throws Exception{
        HashMap<String,LocalDateTime> fechas = new HashMap<>();
        
        for (int i = 0; i < lista.LISTOFSTREAMS.length; i++) {
            String date = getDateOfCreation(lista.LISTOFSTREAMS[i], ClientId, accessToken);
            Instant instant = Instant.parse(date); // convierte a Instant
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            fechas.put(lista.LISTOFSTREAMS[i], dateTime);
        }

        System.out.println("🔢 Ranking por fecha de creación (del más viejo al más nuevo):\n");
        fechas.entrySet().stream()
        .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
        .forEach(entry -> 
        System.out.println(entry.getKey() + ": " + entry.getValue())
    );

    }
}

class TwitchUserResponse {
    List<UserData> data;
}

class UserData {
    private String id;
    private String login;
    private String display_name;
    private String type;
    private String broadcaster_type;
    private String description;
    private String profile_image_url;
    private String offline_image_url;
    private String view_count;
    private String created_at;

    public String getDisplay_name() {
        return display_name;
    }

    public String getLogin() {
        return login;
    }

    public String getBroadcaster_type() {
        return broadcaster_type;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getOffline_image_url() {
        return offline_image_url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getView_count() {
        return view_count;
    }

    public String getId() {
        return id;
    }

}
class numeroDeSeguidores{
    private int total;
    private String[] data;
    private Object pagination;

    public int getTotal() {
        return total;
    }

    public String[] getData() {
        return data;
    }

    public Object getPagination() {
        return pagination;
    }

}

class ListOfStreams{
    final String[] LISTOFSTREAMS = {
            "Abby",
            "Ache",
            "AdriContreras",
            "Agustin",
            "Alexby",
            "Ampeter",
            "Ander",
            "AriGameplays",
            "Arigeli",
            "AuronPlay",
            "Axozer",
            "Beniju",
            "ByCalitos",
            "ByViruzz",
            "Carrera",
            "Celopan",
            "Cheeto",
            "CrystalMolly",
            "DarioEmehache",
            "Dheylo",
            "DjMariio",
            "Doble",
            "Elvisa",
            "Elyas360",
            "Folagor",
            "TheGrefg",
            "Guanyar",
            "Hika",
            "Hiper",
            "Ibai",
            "ibelky_",
            "Illojuan",
            "Imantado",
            "IrinaIsasia",
            "Jesskiu",
            "Jopa",
            "JordiWild",
            "kenaivsouza",
            "Keroro",
            "KiddKeo",
            "KikoRivera",
            "Knekro",
            "Koko",
            "KronnoZomberOficial",
            "Leviathan",
            "LitKillah",
            "LolaLolita",
            "Lolito",
            "Luh",
            "Luzu",
            "Mangel",
            "Mayichi",
            "Melo",
            "Missasinfonia",
            "Mixwell",
            "mrjagger",
            "NateGentile7",
            "Nexxuz",
            "LakshartNia",
            "NilOjeda",
            "Nissaxter",
            "OllieGamerz",
            "Orslok",
            "Outconsumer",
            "PapiGavi",
            "Paracetamor",
            "Patica",
            "PaulaGonu",
            "Pausenpaii",
            "Perxitaa",
            "NoSoyPlex",
            "polispol1",
            "Quackity",
            "Recuerdop",
            "Reven",
            "Rivers",
            "Robertpg",
            "Roier",
            "Rojuu",
            "Rubius",
            "Shadoune",
            "Silithur",
            "Spoksponha",
            "Spreen",
            "Spursito",
            "Staxx",
            "Suzyroxx",
            "Vicens",
            "Vituber",
            "WerlyB",
            "Xavi",
            "Xcry",
            "elxokas",
            "Zarcort",
            "Zeling",
            "Zorman"
        };
}