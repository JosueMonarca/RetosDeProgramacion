public class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre, "Miau");
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " hace el sonido: " + getSonido());
    }
}
