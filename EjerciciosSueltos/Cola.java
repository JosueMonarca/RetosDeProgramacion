public class Cola {
    Object[] elementos;
    int capacidad;
    int tamano;
    boolean estaVacia;
    boolean tieneTope;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.tamano = 0;
        this.estaVacia = true;
        this.tieneTope = true;
    }

    public Cola(){
        this(10); // Por defecto, la capacidad es 10
        this.tieneTope = false; // No tiene tope inicialmente
    }

    public Cola (Object[] elementos){
        this.elementos = elementos;
        this.capacidad = elementos.length;
        this.tamano = elementos.length;
        this.estaVacia = (tamano == 0);
        this.tieneTope = false;
    }

    // GETTERS Y SETTERS
    public Object[] getElementos() {
        return elementos;
    }

    public void setElementos(Object[] elementos) {
        this.elementos = elementos;
        this.capacidad = elementos.length;
        this.tamano = elementos.length;
        this.estaVacia = (tamano == 0);
        this.tieneTope = false;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.tamano = 0;
        this.estaVacia = true;
        this.tieneTope = true;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
        this.estaVacia = (tamano == 0);
        this.tieneTope = true;
    }

    public boolean isEstaVacia() {
        return estaVacia;
    }

    public void add(Object elemento){
        if( tamano == capacidad && tieneTope){
            System.out.println("Cola llena, no se puede añadir el elemento: " + elemento);
        } else if(tamano < capacidad && !tieneTope) {
            elementos[tamano] = elemento;
            tamano++;
            estaVacia = false;
        }else{
            Object[] auxiliar = new Object[capacidad  + 1];

            for (int i = 0; i < auxiliar.length; i++) {
                auxiliar[i] = (i < capacidad)? elementos[i] : elemento;
            }
            elementos = auxiliar;
            capacidad++;
            tamano++;
            estaVacia = false;
        }
    }

    public void remove(){
        if (estaVacia) {
            System.out.println("Cola vacía, no se puede eliminar ningún elemento.");
        } else {
            for (int i = 0; i < tamano - 1; i++) {
                elementos[i] = elementos[i + 1];
            }
            elementos[tamano - 1] = null; // Eliminar el último elemento
            tamano--;
            estaVacia = (tamano == 0);
        }
    }

    public void print(){
        if(estaVacia){
            System.out.println("Cola vacía.");
        } else {
            System.out.print("Contenido de la cola: ");
            for (int i = 0; i < tamano; i++) {
                System.out.print(elementos[i] + (i < tamano - 1 ? ", " : ""));
            }
            System.out.println();
        }
    }
}
