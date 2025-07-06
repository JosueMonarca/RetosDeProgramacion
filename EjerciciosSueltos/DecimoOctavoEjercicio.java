
import java.util.HashSet;
import java.util.Set;
/*
 * EJERCICIO:
 * Utilizando tu lenguaje crea un conjunto de datos y realiza las siguientes
 * operaciones (debes utilizar una estructura que las soporte):
 * - Añade un elemento al final.
 * - Añade un elemento al principio.
 * - Añade varios elementos en bloque al final.
 * - Añade varios elementos en bloque en una posición concreta.
 * - Elimina un elemento en una posición concreta.
 * - Actualiza el valor de un elemento en una posición concreta.
 * - Comprueba si un elemento está en un conjunto.
 * - Elimina todo el contenido del conjunto.
 *
 * DIFICULTAD EXTRA (opcional):
 * Muestra ejemplos de las siguientes operaciones con conjuntos:
 * - Unión.
 * - Intersección.
 * - Diferencia.
 * - Diferencia simétrica.
 */
public class DecimoOctavoEjercicio {
    public static void main(String[] args) {
        Object[] conjunto = new Object[0];

        // Añadir un elemento al final
        conjunto = addElementToEnd(conjunto, "Elemento 1");
        System.out.println("Añadido al final: " + java.util.Arrays.toString(conjunto));
        // Añadir un elemento al principio
        conjunto = addElementToBeginning(conjunto, "Elemento 0");
        System.out.println("Añadido al principio: " + java.util.Arrays.toString(conjunto));
        // Añadir varios elementos en bloque al final
        conjunto = addElementsToEnd(conjunto, new Object[]{"Elemento 2", "Elemento3"});
        System.out.println("Añadidos al final: " + java.util.Arrays.toString(conjunto));
        // Añadir varios elementos en bloque en una posición concreta
        conjunto = addElementsAtPosition(conjunto, new Object[]{"Elemento A", "Elemento B"}, 2);
        System.out.println("Añadidos en posición 2: " + java.util.Arrays.toString(conjunto));
        // Eliminar un elemento en una posición concreta
        conjunto = removeElementAtPosition(conjunto, 3);
        System.out.println("Eliminado en posición 3: " + java.util.Arrays.toString(conjunto));
        // Actualizar el valor de un elemento en una posición concreta
        conjunto[1] = "Elemento Actualizado";
        System.out.println("Actualizado en posición 1: " + java.util.Arrays.toString(conjunto));
        // Comprobar si un elemento está en un conjunto
        String elementoABuscar = "Elemento 2";
        boolean contieneElemento = java.util.Arrays.asList(conjunto).contains(elementoABuscar);
        System.out.println("¿Contiene '" + elementoABuscar + "'? " + contieneElemento);
        // Eliminar todo el contenido del conjunto 
        conjunto = new Object[0];
        System.out.println("Contenido eliminado: " + java.util.Arrays.toString(conjunto));
        // DIFICULTAD EXTRA
        HashSet<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        HashSet<String> set2 = new HashSet<>();
        set2.add("B");
        set2.add("C");
        set2.add("D");
        // Unión
        Set<String> union = Union(set1, set2);
        System.out.println("Unión: " + union);
        // Intersección
        Set<String> intersection = Intersection(set1, set2);
        System.out.println("Intersección: " + intersection);
        // Diferencia
        Set<String> difference = Difference(set1, set2);
        System.out.println("Diferencia: " + difference);
        // Diferencia simétrica
        Set<String> symmetricDifference = SymmetricDifference(set1, set2);
        System.out.println("Diferencia simétrica: " + symmetricDifference);
    }

    private static Object[] addElementToEnd(Object[] array, Object element) {
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }
    private static Object[] addElementToBeginning(Object[] array, Object element) {
        Object[] newArray = new Object[array.length + 1];
        newArray[0] = element;
        System.arraycopy(array, 0, newArray, 1, array.length);
        return newArray;
    }

    private static Object[] addElementsToEnd(Object[] array, Object[] elements) {
        Object[] newArray = new Object[array.length + elements.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(elements, 0, newArray, array.length, elements.length);
        return newArray;
    }

    private static Object[] addElementsAtPosition(Object[] array, Object[] elements, int position) {
        if (position < 0 || position > array.length) {
            throw new IndexOutOfBoundsException("Posición fuera de los límites del arreglo");
        }
        Object[] newArray = new Object[array.length + elements.length];
        System.arraycopy(array, 0, newArray, 0, position);
        System.arraycopy(elements, 0, newArray, position, elements.length);
        System.arraycopy(array, position, newArray, position + elements.length, array.length - position);
        return newArray;
    }

    private static Object[] removeElementAtPosition(Object[] array, int position) {
        if (position < 0 || position >= array.length) {
            throw new IndexOutOfBoundsException("Posición fuera de los límites del arreglo");
        }
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, position);
        System.arraycopy(array, position + 1, newArray, position, array.length - position - 1);
        return newArray;
    }

    private static Set<String> Union (HashSet <String> set1, HashSet<String> set2) {
        HashSet<String> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    private static Set<String> Intersection (HashSet <String> set1, HashSet<String> set2) {
        HashSet<String> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    private static Set<String> Difference (HashSet <String> set1, HashSet<String> set2) {
        HashSet<String> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        return differenceSet;
    }

    private static Set<String> SymmetricDifference (HashSet <String> set1, HashSet<String> set2) {
        HashSet<String> symmetricDifferenceSet = new HashSet<>(set1);
        symmetricDifferenceSet.addAll(set2);
        Set<String> intersection = Intersection(set1, set2);
        symmetricDifferenceSet.removeAll(intersection);
        return symmetricDifferenceSet;
    }
}