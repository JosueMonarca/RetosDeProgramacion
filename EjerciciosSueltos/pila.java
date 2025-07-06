


public class pila {
    private Object[] elemts;
    private int top;
    private boolean hasCap = false;

    // Constructor
    public pila(int size) {
        this.elemts = new Object[size];
        this.top = -1; // Pila vacía
        hasCap = true; // Indica que la pila tiene capacidad definida
    }

    public pila(){
        this.top = -1; // Pila vacía
        this.elemts = new Object[10]; // Pila con capacidad por defecto
    }

    public pila (Object[] elements){
        this.elemts = elements;
        this.top = elements.length - 1; // Pila llena
    }

    //GETTERS AND SETTERS
    public Object[] getElemts() {
        return elemts;
    }
    public void setElemts(Object[] elemts) {
        this.elemts = elemts;
        this.top = elemts.length - 1; // Pila llena
    }
    public int getTop() {
        return top;
    }
    public void setTop(int top) {
        this.top = top;
    }

    // Métodos de la pila
    public boolean isEmpty() {
        return top == -1;
    }

    public void add(Object element){
        if (top < elemts.length - 1) {
            top ++;
            elemts[top] = element; // Añadir elemento y actualizar el tope
        } else if (hasCap){
            System.out.println("Pila llena, no se puede añadir el elemento: " + element);
        } else{
            Object[] newElements = new Object[elemts.length + 1];
            for (int i = 0; i < elemts.length; i++) {
                newElements[i] = (i < elemts.length-1)? elemts[i]: element;
            }
            this.elemts = newElements;
            this.top++;
        }
    }

    public void remove(){
        if (!isEmpty()) {
            if (hasCap) {
                elemts[top--] = null; // Eliminar el elemento en el tope y actualizarlo
            } else {
                top--;
            }
        } else {
            System.out.println("Pila vacía, no se puede eliminar un elemento.");
        }
    }

    public int size() {
        return top + 1; // Retorna el número de elementos en la pila
    }

    public void print(){
        if (isEmpty()){
            System.out.println("Pila vacía.");
        }else{
            System.out.println("Contenido de la pila:");
            for (int i = top; i >= 0; i--) {
                System.out.println(elemts[i]);
            }
        }
    }
}
