package ejercicio.cuadragesimo;

public class Calendario implements ICalendario{
    private final String[][] DIASTOTALES;
    private final String[] DIASSELECCIONADOS;

    public Calendario(){
        DIASTOTALES = new String[4][6];
        DIASSELECCIONADOS = new String[ICalendario.DIAS];
        int diaTotal = 0;

        for (String[] DIASTOTALES1 : DIASTOTALES) {
            for (int col = 0; col < DIASTOTALES[0].length; col++) {
                diaTotal++;
                DIASTOTALES1[col] = (diaTotal < 10 ? "0" : "") + diaTotal;
            }
        }

        for(int i = 0; i < DIASSELECCIONADOS.length; i++){
            DIASSELECCIONADOS[i] = "";
        }
    }

    @Override
    public void mostrarCalendario() {
        System.out.println(Calendario.NOMBRE);

        for (int fila = 0; fila < DIASTOTALES.length; fila++) {
            mostrarMargen();
            System.out.println();
            mostrarSemana(fila);
            System.out.println();
            mostrarMargen();
            System.out.println();
        }

    }

    private void mostrarMargen(){
        for(int i = 1; i <= DIASTOTALES[0].length; i++){
            System.out.print("**** ");
        }
    }

    private void mostrarSemana(int fila) {
        for (int columna = 0; columna < DIASTOTALES[0].length; columna++) {
            mostrarDia(fila, columna);
        }
    }


    private void mostrarDia(int i, int j){
        boolean seleccionado = false;
        
        for (String diaSeleccionado : DIASSELECCIONADOS) {
            if (DIASTOTALES[i][j].equals(diaSeleccionado)) {
                seleccionado = true;
                break;
            }
        }
        if(!seleccionado)System.out.print("*"+ DIASTOTALES[i][j] + "* ");
        else System.out.print("**** ");
    }

    @Override
    public void seleccionarDia(int dia) {
        if(dia < 25 && dia > 0) DIASSELECCIONADOS[dia - 1] = DIASTOTALES[(dia - 1) / 6][(dia - 1) % 6];
    }

    @Override
    public boolean diaSeleccionado(int dia) {
        if(dia < 25 && dia > 0) return DIASSELECCIONADOS[dia - 1].equals(DIASTOTALES[(dia - 1) / 6][(dia - 1) % 6]);
        else return false;
    }
}
