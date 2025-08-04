package ejercicio.cuadragesimo;

import java.util.ArrayList;

public class CajaFuerte {
    private final String CLAVE = "a1b2";

    public boolean abrir(String clave) {
        return CLAVE.equals(clave);
    }

    public ArrayList<String> obtenerDigitosCoinciden(String clave){
        ArrayList<String> digitosCoinciden = new ArrayList<>();
        for (int i = 0; i < clave.length(); i++) {
            if (CLAVE.contains(String.valueOf(clave.charAt(i)))) {
                digitosCoinciden.add(String.valueOf(clave.charAt(i)));
            }
        }
        return digitosCoinciden;
    }
}
