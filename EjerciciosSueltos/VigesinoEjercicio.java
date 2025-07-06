
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

/*
 * EJERCICIO:
 * Utilizando un mecanismo de peticiones HTTP de tu lenguaje, realiza
 * una petición a la web que tú quieras, verifica que dicha petición
 * fue exitosa y muestra por consola el contenido de la web.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utilizando la PokéAPI (https://pokeapi.co), crea un programa por
 * terminal al que le puedas solicitar información de un Pokémon concreto
 * utilizando su nombre o número.
 * - Muestra el nombre, id, peso, altura y tipo(s) del Pokémon
 * - Muestra el nombre de su cadena de evoluciones
 * - Muestra los juegos en los que aparece
 * - Controla posibles errores
 */
public class VigesinoEjercicio {
    public static void main(String[] args) {
        String url = "https://pokeapi.co/api/v2/pokemon/ditto";
        String respuesta ;
        try {
            respuesta = peticionHttpGet(url);
            //System.out.println(respuesta);
            String resParse = parser(respuesta).toString();
            System.out.println(resParse);
        } catch (Exception e) {
            System.out.println("No se pudo procesar la peticion "+ e.getMessage());
        }finally{
            System.out.println("Finalmente si se acaba el programa");
        }
    }

    private static String peticionHttpGet(String urlParaVisitar) throws Exception{
        StringBuilder resultado = new StringBuilder();

        URL url = new URL(urlParaVisitar);

        HttpURLConnection conexion = (HttpsURLConnection)url.openConnection();
        conexion.setRequestMethod("GET");

        try(BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));){
        String linea;

        while((linea = rd.readLine()) != null){
            resultado.append(linea);
        }
        rd.close();

        return resultado.toString();
        }
    }

    private static Object parser(String obj){
        obj = obj.trim();
        char tipo = obj.charAt(0);

        if(Character.isDigit(tipo) || tipo == '-'){
            return parserNumber(obj);
        }

        switch (tipo) {
            case '[' ->{
                return parserArray(obj);
            }
            case '{' ->{
                return "si se pudo";
            }
            case '"' ->{
                return parseString(obj);
            }
            case 'f' ->{
                return parserBoolean(obj);
            }
            case 't' ->{
                return parserBoolean(obj);
            }
            case 'n' ->{
                return null;
            }
            default ->{
                throw new RuntimeException("Tipo JSON no reconocido: " + tipo);
            }
        }
    }

    private static double parserNumber(String obj){
        return Double.parseDouble(obj);
    }

    private static boolean parserBoolean(String obj){
        return Boolean.parseBoolean(obj);
    }
    
    private static List<Object> parserArray(String obj){
        List<Object> resultado = new ArrayList<>();
        obj = obj.replace(" ", "");
        
        if(obj.startsWith("[") && obj.endsWith("]")){
            obj = obj.substring(1, obj.length()-1);
        }
        
        for(int i = 0; i < obj.length() ; i++){
            if(obj.charAt(i) == '"' ){
                String newObj = obj.substring(i);
                String palabra = parseString(newObj, true);
                int numDeLetras = Integer.parseInt(obj.charAt(obj.length()-1)+"");
                palabra = palabra.substring(0,palabra.length()-1);
                i = i + numDeLetras;
                resultado.add(palabra);
            }
        }
        
        return resultado;
    }

    private static String parseString (String obj){
        StringBuilder constructor = new StringBuilder();
        boolean dentroDeUnString = false;
        String res = "";
        
        for(int i = 0; i < obj.length() ; i++){
            if(obj.charAt(i) == '"' && !dentroDeUnString){
                dentroDeUnString = true;
            }
            else if (obj.charAt(i) == '"' && dentroDeUnString){
                res = constructor.toString();
                constructor.setLength(0);
                break;
            }else if (dentroDeUnString) {
                constructor.append(obj.charAt(i));
            }
        }
        return res;
    }    

    private static String parseString (String obj, boolean contador){
        StringBuilder constructor = new StringBuilder();
        boolean dentroDeUnString = false;
        int cont = 0;
        String res = "";
        
        if (contador){
            for(int i = 0; i < obj.length() ; i++){
                if(obj.charAt(i) == '"' && !dentroDeUnString){
                    dentroDeUnString = true;
                    continue;
                }
                else if (obj.charAt(i) == '"' && dentroDeUnString){
                    res = constructor.toString();
                    constructor.setLength(0);
                    cont ++;
                    break;
                }else if (dentroDeUnString) {
                    constructor.append(obj.charAt(i));
                }
                cont ++;
            }
            return res+Integer.toString(cont);
        }else{
            for(int i = 0; i < obj.length() ; i++){
                if(obj.charAt(i) == '"' && !dentroDeUnString){
                    dentroDeUnString = true;
                }
                else if (obj.charAt(i) == '"' && dentroDeUnString){
                    res = constructor.toString();
                    constructor.setLength(0);
                    break;
                }else if (dentroDeUnString) {
                    constructor.append(obj.charAt(i));
                }
            }
        }
        return res;
    } 
}
