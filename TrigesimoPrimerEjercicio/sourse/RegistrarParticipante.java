
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrarParticipante {
    private final ArrayList<Participante> PARTICIPANTES;

    public RegistrarParticipante() {
        this.PARTICIPANTES = new ArrayList<>();
    }

    public ArrayList<Participante> getPARTICIPANTES() {
        return PARTICIPANTES;
    }

    public void addParticipante(Participante participante) {
        this.PARTICIPANTES.add(participante);
    }

    public void addParticipante(Scanner scanner){
        System.out.println("Ingrese el nombre del participante: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el pais");
        String pais = scanner.nextLine();

        System.out.println("Ingrese el ID");
        String ID = scanner.nextLine();

        boolean[] existe = {false};

        PARTICIPANTES.forEach(participante ->{
            if(participante.getNombre().equals(nombre) && participante.getPais().equals(pais)){
                System.out.println("Ya se registro a "+ nombre);
                existe[0] = true;
            }else if(participante.getID().equals(ID)){
                System.out.println("No pueden aver 2 personas con el mismo ID");
                existe[0] = true;
            }
        });

        if(!existe[0]){
            PARTICIPANTES.add(new Participante(nombre, ID, pais));
        }
    }

    public void mostrarParticipantes(){
        for(Participante par : PARTICIPANTES){
            System.out.println("participante " + par);
        }
    }
    
    public Participante buscarParticipante(String nombre){
        for(Participante par : PARTICIPANTES){
            if( par.getNombre().equals(nombre)){
                return par;
            }
        }
        return null;
    }

    public int getSize(){
        return PARTICIPANTES.size();
    }

    public Participante getUltimoParticipante(){
        return PARTICIPANTES.get(PARTICIPANTES.size()-1);
    }
}
