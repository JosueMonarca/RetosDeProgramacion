
import java.util.regex.Pattern;

/*
 * EJERCICIO:
 * Utilizando tu lenguaje, explora el concepto de expresiones regulares,
 * creando una que sea capaz de encontrar y extraer todos los números
 * de un texto.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea 3 expresiones regulares (a tu criterio) capaces de:
 * - Validar un email.
 * - Validar un número de teléfono.
 * - Validar una url.
 */
public class DecimosextoEjericicio {
    public static void main(String[] args) {
        double[] num = obtenerNumeros("1234567qwertyu");
        System.out.println(java.util.Arrays.toString(num));

        boolean email = validaEmail("jmonarca522@gmail.com");
        System.out.println(email);

        boolean numero = validarNumero("123456789");
        System.out.println(numero);

        boolean url = validarUrl("https://chatgpt");
        System.out.println(url);
    }
    private static double[] obtenerNumeros(String str) {
        // Split the string by non-digit characters to extract numbers
        String[] arrayStr = str.split("[^\\d\\.]+");
        java.util.List<Double> numbers = new java.util.ArrayList<>();

        for (String s : arrayStr) {
            if (!s.isEmpty()) {
                try {
                    numbers.add(Double.valueOf(s));
                } catch (NumberFormatException e) {
                    // Ignore non-number strings
                }
            }
        }
        // Convert List<Double> to double[]
        double[] result = new double[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    private static boolean  validaEmail(String correo){
        return Pattern.matches("[\\w._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", correo);
    }

    private static boolean validarNumero(String numero){
        return Pattern.matches("\\d{9}", numero);
    }

    private static boolean validarUrl(String url){
        return Pattern.matches("^https?://[\\w.-]+(\\.[a-z]{2,})+.*$\r\n", url);
    }
}
