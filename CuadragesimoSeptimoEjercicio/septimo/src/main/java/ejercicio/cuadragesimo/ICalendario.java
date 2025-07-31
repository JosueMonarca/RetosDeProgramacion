package ejercicio.cuadragesimo;

public interface ICalendario {
    public static final String NOMBRE = "Calendario de adviento";
    public static final int DIAS = 24;
    public void mostrarCalendario();
    public void seleccionarDia(int dia);
    public boolean diaSeleccionado(int dia);
}
