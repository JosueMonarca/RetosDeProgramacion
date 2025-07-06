public class ImpresoraTodo implements ImprimirBlancoNegro, ImprimirColor, EnviarRecivirFax{
    private final String BLACK = "\033[30m"; 
    private final String PINK = "\033[31m"; 
    private final String GREEN = "\033[32m"; 
    private final String YELLOW = "\033[33m"; 
    private final String PURPLE = "\033[34m"; 
    private final String RED = "\033[35m"; 
    private final String BLUE = "\033[36m"; 
    private final String WHITE = "\033[37m"; 
    private final String RESET = "\u001B[0m";

    @Override
    public void imprimirBlancoNegro(String text, int copias){
        for (int i = 0; i < copias; i++) {
            System.out.println();
        }
    }

    @Override
    public void imprimirColor(String text, String color, int copias){
        String colorCode;

        colorCode = switch(color.toLowerCase()){
            case "black" -> BLACK;
            case "pink" -> PINK;
            case "green" -> GREEN;
            case "yellow" -> YELLOW;
            case "purple" -> PURPLE;
            case "red" -> RED;
            case "blue" -> BLUE;
            case "white" -> WHITE;
            default -> RESET;
        };

        System.out.println(colorCode + text);
    }

    @Override
    public void enviarFax(String numero, String documento){
        System.out.println("Eviando fax al numero: "+ numero);
        System.out.println("Documento enviado: "+ documento);
    }

    @Override
    public String recibirFax (String numero){
        return "Fax recibido desde el numero: "+numero;
    }
}
