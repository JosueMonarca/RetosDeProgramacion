public class Main {
    public static void main(String[] args) {
        CajaGenerica<String> cg = new CajaGenerica<>();
        cg.setContenido("Hola Mundo");
        System.out.println("El contenido de la caja es " + cg.getContenido());

        CajaGenerica<Integer> ci = new CajaGenerica<>();
        ci.setContenido(23);
        System.out.println("EL contenido es :"+ci.getContenido());
    }
}
