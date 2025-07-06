
import java.util.HashMap;
import java.util.Map;

public class ReguladorDeMedallas {
    private final Map<String,Integer> PAISESMEDALLAS;
    private static ReguladorDeMedallas PAISES ;

    private ReguladorDeMedallas(){
        PAISESMEDALLAS = new HashMap<>();
    }

    public static ReguladorDeMedallas getInstancia (){
        if(PAISES == null){
            PAISES = new ReguladorDeMedallas();
        }
        return PAISES;
    }

    public void addMedallas(String pais,int medallas){
        if(!PAISESMEDALLAS.containsKey(pais)){
            PAISESMEDALLAS.put(pais, medallas);
        }else {
            PAISESMEDALLAS.put(pais, PAISESMEDALLAS.get(pais)+medallas);
        }
    }

    public Map<String, Integer> getMedallero(){
        return PAISESMEDALLAS;
    }
}
