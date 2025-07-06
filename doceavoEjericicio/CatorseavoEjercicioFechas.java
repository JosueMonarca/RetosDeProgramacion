import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CatorseavoEjercicioFechas {
    
    public static void main(String[] args) {
        añoDeCumpleaños();
        formateo();
    }

    private static void añoDeCumpleaños(){
        // Fecha actual
        LocalDateTime ahora = LocalDateTime.now();

        // Fecha de nacimiento (puedes cambiarla)
        LocalDateTime nacimiento = LocalDateTime.of(2006, 9, 19, 12, 30, 0);

        // Calcular diferencia de años
        Period edad = Period.between(nacimiento.toLocalDate(), ahora.toLocalDate());
        System.out.println("Han pasado " + edad.getYears() + " años.");
    }

    private static void formateo(){
        LocalDateTime nacimiento = LocalDateTime.of(2006, 6, 19, 12, 30, 0);
        System.out.println("\nFormateos de la fecha de nacimiento:");
            DateTimeFormatter[] formatos = new DateTimeFormatter[] {
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd MMMM yyyy"),     // 19 junio 2006
            DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM yyyy"), // lunes 19 de junio 2006
            DateTimeFormatter.ofPattern("HH:mm:ss"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("D 'del año' yyyy"), // Día del año
            DateTimeFormatter.ofPattern("'Semana' w 'del año'"),
            DateTimeFormatter.ofPattern("MMM yyyy"),          // Mes y año
            DateTimeFormatter.ofPattern("'Era:' G")           // Era (AD/BC)
        };

        for (DateTimeFormatter formato : formatos) {
            System.out.println("→ " + nacimiento.format(formato));
        }

    }

}
