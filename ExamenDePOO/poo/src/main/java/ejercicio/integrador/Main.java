package ejercicio.integrador;

public class Main {
    public static void main(String[] args) {
        IVideojuego v1 = new Videojuego("1", "The Legend of Zelda", "Nintendo Switch", "1", "Aventura");
        IVideojuego v2 = new Videojuego("2", "Super Mario Odyssey", "Nintendo Switch", "1", "Plataformas");
        IVideojuego v3 = new Videojuego("3", "God of War", "PlayStation 4", "1", "Acción/Aventura");
        IVideojuego v4 = new Videojuego("4", "Halo Infinite", "Xbox Series X", "1", "Shooter");
        IVideojuego v5 = new Videojuego("5", "Minecraft", "PC", "1", "Sandbox");

        //salto de linea
        System.out.println();

        GestorBDVideojuegos gestor = new GestorBDVideojuegos();
        if(gestor.agregarVideojuego(v1))System.out.println("videojuego agregado: " + v1.getNombre());
        if(gestor.agregarVideojuego(v2))System.out.println("videojuego agregado: " + v2.getNombre());
        if(gestor.agregarVideojuego(v3))System.out.println("videojuego agregado: " + v3.getNombre());
        if(gestor.agregarVideojuego(v4))System.out.println("videojuego agregado: " + v4.getNombre());
        if(gestor.agregarVideojuego(v5))System.out.println("videojuego agregado: " + v5.getNombre());

        System.out.println(gestor.toString());

        //Cambiar el nombre y la contidad de jugadores de 2 juegos
        gestor.cambiarAtributo(AtributosVideojuegos.NOMBRE, "The Legend of Zelda: Breath of the Wild", "1");
        gestor.cambiarAtributo(AtributosVideojuegos.CANTIDAD_JUGADORES, "2", "2");

        //mostrar despues de las modificaciones
        System.out.println(gestor.toString());
        
        //Cambiar la consola de un juego a nintendo 64
        gestor.cambiarAtributo(AtributosVideojuegos.CONSOLA, "Nintendo 64", "1");

        //String vjNintendo = gestor.filtrarDondeEs("Nintendo 64", AtributosVideojuegos.CONSOLA);

        //System.out.println(vjNintendo);

        //mostrar los videojuegos de nintendo 64
        String vd = gestor.filtrarDondeEs("Nintendo 64", AtributosVideojuegos.CONSOLA);
        System.out.println(vd);
    }
}