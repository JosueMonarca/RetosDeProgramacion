public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre, "Guau");
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " hace el sonido: " + getSonido());
    }
}
