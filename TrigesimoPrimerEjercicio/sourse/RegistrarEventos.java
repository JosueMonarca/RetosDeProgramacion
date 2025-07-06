import java.util.*;

public class RegistrarEventos {
    private final ArrayList<Evento> EVENTOS;

    //Constructores
    public RegistrarEventos(){
        this.EVENTOS = new ArrayList<>();
    }

    //Getters y Setters
    public ArrayList<Evento> getEVENTOS() {
        return EVENTOS;
    }

    public void addEvento(Scanner scanner){
        System.out.println("Ingrese el nombre del evento: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la fecha del evento (dd/mm/yyyy): ");
        String fechaStr = scanner.nextLine();
        String[] fecha = fechaStr.split("/");
        if(!esEntero(fecha[0]) || !esEntero(fecha[1]) || !esEntero(fecha[2]) ){
            int dia = Integer.parseInt(fecha[0]);
            int mes = Integer.parseInt(fecha[1]);
            int anio = Integer.parseInt(fecha[2]);
            Calendar calendar = Calendar.getInstance();
            calendar.set(anio, mes-1, dia);
            Date fechaEvento = calendar.getTime();
    
            System.out.println("Ingrese el lugar del evento: ");
            String lugar = scanner.nextLine();
            
            System.out.println("Ingrese el ID del evento: ");
            String ID = scanner.nextLine();
    
            boolean existe = false;
    
            for (Evento evento : EVENTOS) {
                if (evento.getID().equals(ID)) {
                    System.out.println("Ya existe un evento con ese ID.");
                    existe = true;
                } else if (evento.getNombre().equals(nombre)) {
                    System.out.println("Ya existe un evento con ese nombre.");
                    existe = true;
                } else if (evento.getFecha().equals(fechaEvento) && evento.getLugar().equals(lugar)){
                    System.out.println("Se sobreponen EVENTOS en la misma fecha y lugar.");
                    existe = true;
                }
            }
    
            if(!existe){
                Evento nuevoEvento = new Evento(nombre, fechaEvento, lugar, ID);
                EVENTOS.add(nuevoEvento);
            }
        }
    }

    public void mostrarEVENTOS() {
        for (Evento evento : EVENTOS) {
            System.out.println(evento);
        }
    }

    public Evento buscarEvento(String nombre){
        for (Evento evento : EVENTOS){
            if(evento.getNombre().equals(nombre)){
                return evento;
            }
        }
        return null;
    }

    public static boolean esEntero(String texto) {
    try {
        int a = Integer.parseInt(texto); // Si falla, lanza excepción
        if (a < 10){//solo se hace para que no marque advertencia y deje de estar chingando
            return true;
        } 
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

}
