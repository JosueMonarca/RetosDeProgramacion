
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);){
            
        System.out.println("----------------------Bienvenido------------------");
        System.out.println("Porfavor introdusca la vida inicial del wolverine :");
        int vida1 = scanner.nextInt();
        System.out.println("Porfavor introdusca la vida del Deadpool: ");
        int vida2 = scanner.nextInt();

        Wolverine wv = new Wolverine(vida1);
        Deadpool dp = new Deadpool(vida2);

        Batalla ba = new Batalla(wv, dp);
        ba.batalla();

        scanner.close();
        }
    }
}
