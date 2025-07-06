import java.util.Arrays;
import java.util.Scanner;
/*
 * EJERCICIO:
 * Muestra ejemplos de todas las operaciones que puedes realizar con cadenas de caracteres
 * en tu lenguaje. Algunas de esas operaciones podrían ser (busca todas las que puedas):
 * - Acceso a caracteres específicos, subcadenas, longitud, concatenación, repetición,
 *   recorrido, conversión a mayúsculas y minúsculas, reemplazo, división, unión,
 *   interpolación, verificación...
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un programa que analice dos palabras diferentes y realice comprobaciones
 * para descubrir si son:
 * - Palíndromos
 * - Anagramas
 * - Isogramas
 */

public class QuintoEjercicio {
    public static void main(String[] args) {
        String str1 = "Hola";
        String str2 = "Mundo";
        try (Scanner scanner = new Scanner(System.in)) {

            // Acceso a caracteres específicos
            char firstChar = str1.charAt(0);// la funcion chartAt devuelve el carater de la posicion que se le dio como
                                            // parametro
            System.out.println("Primer carácter de str1: " + firstChar);

            // concatenacion
            String concatenated = str1 + " " + str2;
            System.out.println("Cadena concatenada: " + concatenated);

            // minusculas y mayusculas
            String upperStr1 = str1.toUpperCase();// la funcion toUpperCase devuelve la cadena en mayusculas
            String lowerStr2 = str2.toLowerCase();// la funcion toLowerCase devuelve la cadena en minusculas
            System.out.println("str1 en mayúsculas: " + upperStr1);
            System.out.println("str2 en minúsculas: " + lowerStr2);

            // longitud
            int lengthStr1 = str1.length();// la funcion length devuelve la longitud de la cadena
            System.out.println("Longitud de str1: " + lengthStr1);

            System.out.print(str1.getClass());// la funcion getClass devuelve la clase de la cadena

            // reemplazo
            String replacedStr1 = str1.replace('o', 'a');// la funcion replace devuelve la cadena reemplazando el
                                                         // caracter que se le dio como parametro
            System.out.println("str1 después de reemplazar 'o' por 'a': " + replacedStr1);

            // interpolacion
            String interpoload = String.format("Hola %s", str2);// la funcion format devuelve la cadena interpolada
            System.out.println(interpoload);

            // verificacion
            boolean startsWithH = str1.startsWith(interpoload);// la funcion startsWith devuelve true si la cadena
                                                               // empieza con el caracter que se le dio como parametro
            System.out.println("str1 empieza con 'H': " + startsWithH);

            // division
            String[] Strdivido = concatenated.split(interpoload);// la funcion split devuelve un array de cadenas
                                                                 // dividiendo la cadena en el caracter que se le dio
                                                                 // como parametro
            System.out.println("Cadena dividida: " + Strdivido[0] + " " + Strdivido[0]);

            // recorrido
            for (int i = 0; i < str1.length(); i++) {// recorre la cadena
                System.out.println("Carácter en posición " + i + ": " + str1.charAt(i));
            }

            // unión
            String joined = String.join(", ", str1, str2);// la funcion join devuelve la cadena unida con el caracter
                                                          // que se le dio como parametro
            System.out.println("Cadena unida: " + joined);

            // comprobacion
            boolean isEmpty = str1.isEmpty();// la funcion isEmpty devuelve true si la cadena esta vacia
            System.out.println("str1 está vacía: " + isEmpty);

            // comprobacion de igualdad
            boolean equals = str1.equals(str2);// la funcion equals devuelve true si la cadena es igual a la cadena que
                                               // se le dio como parametro
            System.out.println("str1 es igual a str2: " + equals);

            // comprobacion de igualdad ignorando mayusculas
            boolean equalsIgnoreCase = str1.equalsIgnoreCase(str2);// la funcion equalsIgnoreCase devuelve true si la
                                                                   // cadena es igual a la cadena que se le dio como
                                                                   // parametro ignorando mayusculas
            System.out.println("str1 es igual a str2 (ignorando mayúsculas): " + equalsIgnoreCase);

            // comprobacion de contenido
            boolean contains = str1.contains("ol");// la funcion contains devuelve true si la cadena contiene el
                                                   // caracter que se le dio como parametro
            System.out.println("str1 contiene 'ol': " + contains);

            // comprobacion de inicio
            boolean startsWith = str1.startsWith("Ho");// la funcion startsWith devuelve true si la cadena empieza con
                                                       // el caracter que se le dio como parametro
            System.out.println("str1 empieza con 'Ho': " + startsWith);

            // comprobacion de fin
            boolean endsWith = str1.endsWith("la");// la funcion endsWith devuelve true si la cadena termina con el
                                                   // caracter que se le dio como parametro
            System.out.println("str1 termina con 'la': " + endsWith);

            // comprobacion de posicion
            int indexOf = str1.indexOf("o");// la funcion indexOf devuelve la posicion del caracter que se le dio como
                                            // parametro
            System.out.println("Posición de 'o' en str1: " + indexOf);

            // comprobacion de ultima posicion
            int lastIndexOf = str1.lastIndexOf("o");// la funcion lastIndexOf devuelve la ultima posicion del caracter
                                                    // que se le dio como parametro
            System.out.println("Última posición de 'o' en str1: " + lastIndexOf);

            // comprobacion de subcadena
            boolean regionMatches = str1.regionMatches(0, str2, 0, 2);// la funcion regionMatches devuelve true si la
                                                                      // subcadena es igual a la subcadena que se le dio
                                                                      // como parametro
            System.out.println("Subcadena de str1 es igual a subcadena de str2: " + regionMatches);

            // comprobacion de comparacion
            int compareTo = str1.compareTo(str2);// la funcion compareTo devuelve 0 si las cadenas son iguales, -1 si la
                                                 // cadena es menor que la cadena que se le dio como parametro y 1 si la
                                                 // cadena es mayor que la cadena que se le dio como parametro
            System.out.println("Comparación de str1 y str2: " + compareTo);
            // en total la clase String tiene 13 metodos

            // Palindromos
            System.out.println("Ingrese la primer palabra: ");
            String palabra1 = scanner.nextLine();
            System.out.println("Ingrese la segunda palabra: ");
            String palabra2 = scanner.nextLine();

            System.out.println(
                    EsPalindromo(palabra2)
                            ? "La palabra " + palabra2 + " es un palíndromo"
                            : "La palabra " + palabra2 + " no es un palíndromo");

            System.out.println(
                    EsPalindromo(palabra1)
                            ? "La palabra " + palabra1 + " es un palíndromo"
                            : "La palabra " + palabra1 + " no es un palíndromo");

            // Anagramas
            System.out.println(
                    SonAnagramas(palabra1, palabra2)
                            ? "Las palabras " + palabra1 + " y " + palabra2 + " son anagramas"
                            : "Las palabras " + palabra1 + " y " + palabra2 + " no son anagramas");

            // Isogramas
            System.out.println(
                    EsIsograma(palabra1)
                            ? "La palabra " + palabra1 + " es un isograma"
                            : "La palabra " + palabra1 + " no es un isograma");

            System.out.println(
                    EsIsograma(palabra2)
                            ? "La palabra " + palabra2 + " es un isograma"
                            : "La palabra " + palabra2 + " no es un isograma");

        }
    }

    // Comprobación de palíndromo
    private static boolean EsPalindromo(String palabra) {
        String palabraReversa = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            palabraReversa += palabra.charAt(i);
        }
        return palabra.equalsIgnoreCase(palabraReversa);
    }

    // Comprobación de anagramas
    private static boolean SonAnagramas(String palabra1, String palabra2) {
        if (palabra1.length() != palabra2.length()) {
            return false;
        } else {
            char[] palabra1Array = palabra1.toCharArray();
            char[] palabra2Array = palabra2.toCharArray();

            Arrays.sort(palabra1Array);
            Arrays.sort(palabra2Array);

            return Arrays.equals(palabra1Array, palabra2Array);
        }
    }

    // Comprobación de isogramas
    private static boolean EsIsograma(String palabra) {
        char[] palabraArray = palabra.toCharArray();
        Arrays.sort(palabraArray);

        for (int i = 0; i < palabraArray.length - 1; i++) {
            for (int j = 0; j < palabraArray.length - 1; j++) {
                if (palabraArray[i] == palabraArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
