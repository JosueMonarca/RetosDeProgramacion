import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class CreadorDeInformes {
    private final Map <Evento,Stack<Participante>> RESULTADO;
    private final Evento EVENTO;

    public CreadorDeInformes(Map <Evento,Stack<Participante>> RESULTADO, Evento key){
        this.RESULTADO = RESULTADO;
        EVENTO = key;
    }

    public void showInforme(){
        if(RESULTADO != null && RESULTADO.containsKey(EVENTO)){
        Stack<Participante> podio = new Stack<>();
        podio.addAll(RESULTADO.get(EVENTO)); // Copia para no modificar el original

        System.out.println("Los resultados de " + EVENTO.getNombre() + " fueron ");
        System.out.println("El primer lugar se lo lleva el pais " + podio.peek().getPais() + " con " + podio.pop().getNombre() );
        System.out.println("El segundo lugar se lo lleva " + podio.peek().getPais() + " con " + podio.pop().getNombre());
        System.out.println("El tercer lugar se lo lleva " + podio.peek().getPais() + " con " + podio.pop().getNombre());
        }else {
            System.out.println("No se puede generar el informe");
        }
    }

    public static LinkedHashMap<String, Integer> ordenarPorValorDesc(Map<String, Integer> mapa) {
        return mapa.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // ↓ mayor a menor
                .collect(
                        LinkedHashMap::new,
                        (nuevoMap, entrada) -> nuevoMap.put(entrada.getKey(), entrada.getValue()),
                        LinkedHashMap::putAll
                );
    }

    public void showPaises(){
        Map <String, Integer> ordenado = ordenarPorValorDesc(ReguladorDeMedallas.getInstancia().getMedallero());
        ordenado.forEach((pais, puntos) -> 
    System.out.println(pais + ": " + puntos + " puntos"));
    }
}
