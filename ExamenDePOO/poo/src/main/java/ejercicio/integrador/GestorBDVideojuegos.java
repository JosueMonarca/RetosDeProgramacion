package ejercicio.integrador;

import java.util.ArrayList;

public class GestorBDVideojuegos {
    private final ArrayList<IVideojuego> videojuegos;

    public GestorBDVideojuegos(){
        videojuegos = new ArrayList<>();
    }

    public boolean agregarVideojuego(IVideojuego videojuego){
        if(videojuego != null &&
        videojuego.getCodigo() != null &&
        !videojuego.getCodigo().isEmpty() &&
        videojuego.getNombre() != null &&
        !videojuego.getNombre().isEmpty() &&
        videojuego.getConsola() != null &&
        !videojuego.getConsola().isEmpty() &&
        videojuego.getCantidadJugadores() != null &&
        videojuego.getCategoria() != null &&
        !videojuego.getCategoria().isEmpty()) {
            videojuegos.add(videojuego);
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminarVideojuego(IVideojuego videojuego) {
        if (videojuego != null && videojuegos.contains(videojuego)) {
            videojuegos.remove(videojuego);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarVideojuego(String nombre){
        for(IVideojuego videojuego : videojuegos){
            if(videojuego.getNombre().equalsIgnoreCase(nombre)){
                videojuegos.remove(videojuego);
                return true;
            }
        }
        return false;
    }

    public IVideojuego buscarVideojuego(String codigo){
        for(IVideojuego videojuego : videojuegos){
            if(videojuego.getCodigo().equalsIgnoreCase(codigo)){
                return videojuego;
            }
        }
        return null;
    }

    public void cambiarAtributo(AtributosVideojuegos av, String nuevoValor, String codigo){
        IVideojuego vid = buscarVideojuego(codigo);
        if(vid != null){
            switch (av) {
                case CODIGO -> vid.setCodigo(nuevoValor);
                case NOMBRE -> vid.setNombre(nuevoValor);
                case CONSOLA -> vid.setConsola(nuevoValor);
                case CANTIDAD_JUGADORES -> vid.setCantidadJugadores(nuevoValor);
                case CATEGORIA -> vid.setCategoria(nuevoValor);
                default -> throw new AssertionError();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (IVideojuego videojuego : videojuegos) {
            sb.append(videojuego.getNombre())
            .append(" - ")
            .append(videojuego.getConsola())
            .append(" - ")
            .append(videojuego.getCantidadJugadores())
            .append("\n");
        }
        return sb.toString();
    }

    public String filtrarDondeEs(String nombre,AtributosVideojuegos av){
        //StringBuilder sb = new StringBuilder();
        try {
            switch (av) {
            case CODIGO -> {
                StringBuilder sb = new StringBuilder();
                for (IVideojuego videojuego : videojuegos) {
                    if(videojuego.getCodigo().equalsIgnoreCase(nombre))sb.append(videojuego.getNombre()).append("\n");
                }
                return sb.toString();
            }
            case NOMBRE -> {
                StringBuilder sb = new StringBuilder();
                for (IVideojuego videojuego : videojuegos) {
                    if(videojuego.getNombre().equalsIgnoreCase(nombre))sb.append(videojuego.getNombre()).append("\n");
                }
                return sb.toString();
            }
            case CONSOLA -> {
                StringBuilder sb = new StringBuilder();
                for (IVideojuego videojuego : videojuegos) {
                    if(videojuego.getConsola().equalsIgnoreCase(nombre))sb.append(videojuego.getNombre()).append("\n");
                }
                return sb.toString();
            }
            case CANTIDAD_JUGADORES -> {
                StringBuilder sb = new StringBuilder();
                for (IVideojuego videojuego : videojuegos) {
                    if(videojuego.getCantidadJugadores().equalsIgnoreCase(nombre))sb.append(videojuego.getNombre()).append("\n");
                }
                return sb.toString();
            }
            case CATEGORIA -> {
                StringBuilder sb = new StringBuilder();
                for (IVideojuego videojuego : videojuegos) {
                    if(videojuego.getCategoria().equalsIgnoreCase(nombre))sb.append(videojuego.getNombre()).append("\n");
                }
                return sb.toString();
            }
            default -> throw new AssertionError();
        }
        } catch (Exception e) {
            return null;
        }
    }
}
