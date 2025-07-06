import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ManejadorDeEventos {
    private ArrayList <Participante> participantes;
    private  ArrayList<Participante> copia = new ArrayList<>(participantes);
    private Evento event;
    private final Map <Evento,Stack<Participante>> RESULTADO = new HashMap<>();

    public ManejadorDeEventos(){
        this.participantes = new ArrayList<>();
    }

    public ManejadorDeEventos(ArrayList <Participante> pa, Evento eve){
        this.participantes = pa;
        this.event = eve;
    }

    public void setParticipantes(ArrayList<Participante> par){
        participantes = par;
    }

    public void setParticipante( Participante pa){
        participantes.add(pa);
    }

    public void setEvento(Evento ev){
        this.event = ev;
    }

    public Evento getEvento(){
        return event;
    }

    public String getNombreEvento(){
        return event.getNombre();
    }

    public void crearGanadores(){
        if(participantes.isEmpty() || participantes.size() < 3){
            System.out.println("no hay sufisientes participantes.");
        }else {
            Collections.shuffle(copia);
            Stack<Participante> ganadores = new Stack<>();
            ganadores.addAll(copia);
            RESULTADO.put(event, ganadores);
            
            ReguladorDeMedallas reguladorDeMedallas = ReguladorDeMedallas.getInstancia();
            if(ganadores.size() > 3){
                for(int i = 0 ; i < 3; i++){
                    reguladorDeMedallas.addMedallas(ganadores.get(i).getPais(), 3-i);
                }
            }
        }
    }

    public Map <Evento,Stack<Participante>> getGanadores (){
        if(RESULTADO.isEmpty()){
            System.out.println("No se han jugado los juegos");
            return null;
        }else{
            return RESULTADO;
        }
    }

    public void setParticipantes(Scanner scanner){
        boolean continuar = true;
        ArrayList<Participante> aux = new ArrayList<>();
        
        while (continuar) {
            boolean elementoExiste = false;
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Por favor indique que participante desea integrar ");
            String nombre = scanner.nextLine();

            
            for (Participante elem : participantes) {
                if(elem.getNombre().contains(nombre)){
                    elementoExiste = true;
                    aux.add(elem);
                    System.out.println("Participante agregado con exito");
                    break;
                }
            }
            
            if(!elementoExiste){
                System.out.println("El participante introducido no esta reguistrado ¿Desea reguistrarlo?");
                String option = scanner.nextLine();

                if (option.equalsIgnoreCase("si")){
                    RegistrarParticipante rp = new RegistrarParticipante();
                    rp.addParticipante(scanner);
                    aux.add(rp.getUltimoParticipante());
                }else if(option.equalsIgnoreCase("no")){
                    System.out.println("Desea poner continuar");
                    String res = scanner.nextLine();

                    if(res.equalsIgnoreCase("no")){
                        continuar = false;
                        System.out.println("----------saliendo---------");
                    }
                }
            }

            System.out.println("¿Desea continuar?");
            String r = scanner.nextLine();

            if(r.equalsIgnoreCase("no")){
                continuar = false;
            }
        }

        copia = aux;
    }
}
