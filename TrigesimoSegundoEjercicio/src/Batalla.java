public class Batalla {
    private final IHeroe heroe1;
    private final IHeroe heroe2;

    public Batalla(IHeroe heroe1, IHeroe heroe2){
        this.heroe1 = heroe1;
        this.heroe2 = heroe2;
    }

    public void batalla(){
        boolean algunoPerdio = false;
        boolean maximoDaño1 = false;
        boolean maximoDaño2 = false;

        while (!algunoPerdio) {
            if(heroe1.recibioDaño()){
                int daño = heroe2.getDaño();
                if(!maximoDaño1) {
                    System.out.println(heroe2.getNombre() + " ataco y quito " + daño + " de vida a " + heroe1.getNombre());
                    heroe1.setVida(heroe1.getVida() - daño);
                } 
                maximoDaño1 = daño ==heroe2.getmaximoDaño();
                System.out.println(heroe1.getNombre() + "tiene " + heroe1.getVida() + "de vida");
            }else{
                System.out.println(heroe1.getNombre() + " no recibio daño");
                System.out.println(heroe1.getNombre() + "tiene " + heroe1.getVida() + "de vida");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("La batalla fue interrumpida.");
                break;
            }
            if(heroe2.recibioDaño()){
                int daño = heroe1.getDaño();
                if(!maximoDaño2){
                    System.out.println(heroe1.getNombre() + "ataco y quito " + daño + " de vida a " + heroe2.getNombre());
                    heroe2.setVida(heroe2.getVida() - daño);
                }
                maximoDaño2 = daño == heroe1.getmaximoDaño();
                System.out.println(heroe2.getNombre() + "tiene " + heroe2.getVida() + "de vida");
            }else{
                System.out.println(heroe2.getNombre() + " no recibio daño");
                System.out.println(heroe2.getNombre() + "tiene " + heroe2.getVida() + "de vida");
            }
            if(heroe1.getVida() <= 0 || heroe2.getVida() <= 0){
                algunoPerdio = true;
                System.out.println(heroe1.getNombre() + " : " + heroe1.getVida());
                System.out.println(heroe2.getNombre() + " : " + heroe2.getVida());
            }
        }
    }
}
