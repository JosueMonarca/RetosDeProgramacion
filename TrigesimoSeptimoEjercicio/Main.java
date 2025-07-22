import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        
        String token = getToken();
        String popularityOfOasis = getPopularity(token, "");
        String popularityOfLinkinPark = getPopularity(token, "");
            
        int intPopularityOfOasis = Integer.parseInt(popularityOfOasis);
        int intPopularityOfLinkinPark = Integer.parseInt(popularityOfLinkinPark);
            
        if(intPopularityOfOasis > intPopularityOfLinkinPark){
            System.out.println("Oasis es más poular que LinkinPark");
        }
        else{
            System.out.println("LinkinPark es mas popular que Oasis");
        }
        
    }
    
    public static String getToken (){
        StringBuilder token = new StringBuilder();
        try {
            String clientId = "";
            String clientSecret = "";
            String auth = clientId + ":" + clientSecret;

            // Codificar credenciales en Base64
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

            // Crear la conexión
            URL url = new URL("https://accounts.spotify.com/api/token");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Cuerpo de la petición
            String body = "grant_type=client_credentials";
            try (OutputStream os = conn.getOutputStream()) {
                os.write(body.getBytes());
            }

            // Leer respuesta
            int status = conn.getResponseCode();
            System.out.println("Status: " + status);

            StringBuilder content;
           try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
               String inputLine;
               content = new StringBuilder();
               while ((inputLine = in.readLine()) != null) {
                   content.append(inputLine);
               }
           }
            conn.disconnect();
            //System.out.println("Response: " + content.toString());
            
            String value = content.toString();
            int controler = 0;
            
            for(int i = 0; i < content.toString().length(); i++){
                if(value.charAt(i) == '"'){
                    controler++;
                }
                if(controler == 3){
                    token.append(value.charAt(i));
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        token.deleteCharAt(0);
        return token.toString();
    }
    public static String getPopularity(String token, String ID){
    StringBuilder content = new StringBuilder();
    try {
        
        URL url = new URL("https://api.spotify.com/v1/artists/" + ID);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Método GET
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + token);

       // int status = conn.getResponseCode();
       // System.out.println("Status: " + status);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        }

        conn.disconnect();
      //  System.out.println("Response JSON: " + content.toString());

        // Extraer popularidad si quieres (opcional, usando parsing básico):
        String json = content.toString();
        int index = json.indexOf("\"popularity\":");
        if (index != -1) {
            int start = index + "\"popularity\":".length();
            int end = json.indexOf(",", start);
            return json.substring(start, end).trim();
        } else {
            return "No se encontró la popularidad";
        }

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }

    return null;
}
}
