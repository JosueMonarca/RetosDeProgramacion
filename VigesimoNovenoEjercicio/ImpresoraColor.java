public class ImpresoraColor implements ImprimirColor {
    private final String black = "\033[30m"; 
    private final String PINK = "\033[31m"; 
    private final String green = "\033[32m"; 
    private final String yellow = "\033[33m"; 
    private final String PURPLE = "\033[34m"; 
    private final String RED = "\033[35m"; 
    private final String BLUE = "\033[36m"; 
    private final String white = "\033[37m"; 
    private final String reset = "\u001B[0m";
    
    @Override
    public void imprimirColor(String text, String color, int copias){
        String colorCode;

        colorCode = switch (color.toLowerCase()){
            case "black" -> black;
            case "pink" -> PINK;
            case "green" -> green;
            case "yellow" -> yellow;
            case "purple" -> PURPLE;
            case "red" -> RED;
            case "blue" -> BLUE;
            case "white" -> white;
            default -> reset;
        };

        for (int i = 0; i < copias; i++) {
            System.out.println(colorCode + text + reset);
        }
    }
}
