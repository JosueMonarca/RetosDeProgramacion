public class ImpresoraBlacoNegro implements ImprimirBlancoNegro {
    
    @Override
    public void imprimirBlancoNegro(String text, int copias) {
        for (int i = 0; i < copias; i++) {
            System.out.println("Imprimiendo en blanco y negro: " + text);
        }
    }
}
