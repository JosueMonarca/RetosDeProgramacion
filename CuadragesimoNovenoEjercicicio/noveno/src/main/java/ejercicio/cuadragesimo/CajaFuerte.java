package ejercicio.cuadragesimo;

import java.security.SecureRandom;
import java.util.ArrayList;

public class CajaFuerte {
    private final String CLAVE;

    public CajaFuerte(){
        CLAVE = generarClave();
    }

    public String getClave() {
        return CLAVE;
    }

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

    private String generarClave(){
        StringBuilder clave = new StringBuilder();
        String[] numeros = {"1","2","3"};
        String[] letras = {"A","B","C"};
        ArrayList<String> caracteresRepetidos = new ArrayList<>(); 

        SecureRandom random = new SecureRandom();

        while (clave.length() < 4){
            if (random.nextBoolean()) {
                String nuevoCaracter = numeros[random.nextInt(numeros.length)];
                if(!caracteresRepetidos.contains(nuevoCaracter)) {
                    clave.append(nuevoCaracter);
                    caracteresRepetidos.add(nuevoCaracter);
                }
            } else {
                String nuevoCaracter = letras[random.nextInt(letras.length)];
                if(!caracteresRepetidos.contains(nuevoCaracter)) {
                    clave.append(nuevoCaracter);
                    caracteresRepetidos.add(nuevoCaracter);
                }
            }
        }
        return clave.toString();
    }

    private boolean coincidenciaDeCaracter(char letra){
        for (int i = 0; i < CLAVE.length(); i++){
            if(CLAVE.charAt(i) == letra){
                return true;
            }
        }
        return false;
    }

    public String nivelCoincidencia(char letra , int index){
        String mensage;
        if (coincidenciaDeCaracter(letra) && CLAVE.charAt(index) == letra) {
            mensage = letra+" coincide y está en la posición correcta";
        } else if (coincidenciaDeCaracter(letra)) {
            mensage = letra+" coincide pero no está en la posición correcta";
        } else {
            mensage = letra+" no coincide";
        }
        return mensage;
    }
}
