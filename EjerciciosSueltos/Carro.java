public class Carro extends Vehiculo{
    private String marca;
    private String modelo;
    private int anio;

    public Carro(String nombre, String tipo, String marca, String modelo, int anio) {
        super(nombre, tipo);
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    //Getters y Setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public void acelerar(){
        System.out.println("El carro " + getNombre() + " está acelerando.");
    }

    @Override
    public void frenar(){
        System.out.println("El carro " + getNombre() + " está frenando.");
    }
}
