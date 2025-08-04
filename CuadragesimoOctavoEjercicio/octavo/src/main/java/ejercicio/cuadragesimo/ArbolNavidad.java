package ejercicio.cuadragesimo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArbolNavidad implements IArbolNavidad {

    private final String ESTRELLA = "@";
    private final String HOJA = "*";
    private final String LUZ = "+";
    private final String ESFERA = "o";
    private final String TRONCO = "|";

    private final Set<Coordenada> luces = new HashSet<>();
    private final Set<Coordenada> esferas = new HashSet<>();

    private final ArrayList<ArrayList<String>> ARBOL = new ArrayList<>();
    private boolean lucesEncendidas = false;
    private boolean estrellaVisible = false;
    private int altura = 5;

    public ArbolNavidad() {
        crearArbol();
    }

    public ArbolNavidad(int altura) {
        if (altura > 5 && altura % 2 != 0) this.altura = altura;
        else throw new IllegalArgumentException("La altura debe ser un número impar mayor a 5.");
        crearArbol();
    }

    @Override
    public void mostrarArbol() {
        crearArbol();
        for (ArrayList<String> nivel : ARBOL) {
            for (String elemento : nivel) {
                System.out.print(elemento);
            }
            System.out.println();
        }
    }

    private void crearArbol() {
        ARBOL.clear();
        for (int i = 0; i < this.altura; i++) {
            ArrayList<String> nivel = new ArrayList<>();
            int numHojas = (i * 2) + 1;
            int espacios = this.altura - i - 1;

            for (int j = 0; j < espacios; j++) nivel.add(" ");
            for (int j = 0; j < numHojas; j++) nivel.add(HOJA);
            for (int j = 0; j < espacios; j++) nivel.add(" ");

            ARBOL.add(nivel);
        }

        for (Coordenada c : esferas) {
            if (validaCoordenada(c)) ARBOL.get(c.nivel).set(c.index, ESFERA);
        }

        for (Coordenada c : luces) {
            if (validaCoordenada(c)) ARBOL.get(c.nivel).set(c.index, lucesEncendidas ? LUZ : HOJA);
        }

        if (estrellaVisible) agregarEstrella();
        ponerTronco();
    }

    private boolean validaCoordenada(Coordenada c) {
        return c.nivel >= 0 && c.nivel < ARBOL.size()
                && c.index >= 0 && c.index < ARBOL.get(c.nivel).size();
    }

    @Override
    public boolean agregarLuces() {
        if (espaciosDisponibles() < 3) return false;
        agregarDecoraciones(luces, 3);
        return true;
    }

    @Override
    public boolean mostrarEstrella(boolean estrella) {
        if (this.estrellaVisible == estrella) return false;
        this.estrellaVisible = estrella;
        return true;
    }

    @Override
    public boolean agregarEsferas() {
        if (espaciosDisponibles() < 2) return false;
        agregarDecoraciones(esferas, 2);
        return true;
    }

    @Override
    public boolean encenderLuces(boolean lucesEstado) {
        if (this.lucesEncendidas == lucesEstado) return false;
        this.lucesEncendidas = lucesEstado;
        return true;
    }

    @Override
    public boolean eliminarLuces() {
        if (luces.size() < 3) return false;
        eliminarDecoraciones(luces, 3);
        return true;
    }

    @Override
    public boolean eliminarEsferas() {
        if (esferas.size() < 2) return false;
        eliminarDecoraciones(esferas, 2);
        return true;
    }

    @Override
    public boolean cambiarAltura(int nuevaAltura) {
        if (nuevaAltura > 5 && nuevaAltura % 2 != 0) {
            this.altura = nuevaAltura;
            this.luces.clear();
            this.esferas.clear();
            this.lucesEncendidas = false;
            this.estrellaVisible = false;
            return true;
        }
        return false;
    }

    private void agregarEstrella() {
        ArrayList<String> estrella = new ArrayList<>();
        int espacios = this.altura - 1;
        for (int j = 0; j < espacios; j++) estrella.add(" ");
        estrella.add(ESTRELLA);
        ARBOL.add(0, estrella);
    }

    private void ponerTronco() {
        int espacios = this.altura - 2;
        for (int i = 0; i < 2; i++) {
            ArrayList<String> tronco = new ArrayList<>();
            for (int j = 0; j < espacios; j++) tronco.add(" ");
            tronco.add(TRONCO);
            tronco.add(TRONCO);
            tronco.add(TRONCO);
            ARBOL.add(tronco);
        }
    }

    private int espaciosDisponibles() {
        int total = 0;
        for (int i = 0; i < altura; i++) {
            ArrayList<String> fila = ARBOL.get(i);
            for (int j = 0; j < fila.size(); j++) {
                if (fila.get(j).equals(HOJA)) {
                    Coordenada c = new Coordenada(i, j);
                    if (!luces.contains(c) && !esferas.contains(c)) total++;
                }
            }
        }
        return total;
    }

    private void agregarDecoraciones(Set<Coordenada> destino, int cantidad) {
        SecureRandom random = new SecureRandom();
        int agregadas = 0;
        while (agregadas < cantidad) {
            int nivel = random.nextInt(altura);
            ArrayList<String> fila = ARBOL.get(nivel);
            int index = random.nextInt(fila.size());
            Coordenada coord = new Coordenada(nivel, index);
            if (fila.get(index).equals(HOJA)
                    && !luces.contains(coord)
                    && !esferas.contains(coord)) {
                destino.add(coord);
                agregadas++;
            }
        }
    }

    private void eliminarDecoraciones(Set<Coordenada> conjunto, int cantidad) {
        int eliminadas = 0;
        ArrayList<Coordenada> copia = new ArrayList<>(conjunto);
        SecureRandom random = new SecureRandom();
        while (eliminadas < cantidad && !copia.isEmpty()) {
            int pos = random.nextInt(copia.size());
            Coordenada c = copia.remove(pos);
            if (conjunto.remove(c)) eliminadas++;
        }
    }

    private record Coordenada(int nivel, int index) {
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coordenada that = (Coordenada) obj;
            return nivel == that.nivel && index == that.index;
        }

        @Override
        public int hashCode() {
            return nivel * 31 + index;
        }
    }
} 
