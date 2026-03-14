package LDE;

public class LDEOrdenada<T extends Comparable<T>> extends ListaDoblementeEnlazada<T> {
    // Sobrescribimos el metodo add de la clase padre para forzar la inserción en orden
    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);

        // Caso 1: La lista está vacía
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        }
        // Caso 2: Insertar al principio (el dato es menor o igual al primero)
        else if (nuevo.dato.compareTo(primero.dato) <= 0) {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        // Caso 3: Insertar al final (el dato es mayor o igual al último)
        else if (nuevo.dato.compareTo(ultimo.dato) >= 0) {
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        // Caso 4: Insertar en una posición intermedia
        else {
            ElementoDE<T> actual = primero;

            // Recorremos la lista hasta encontrar un elemento mayor al dato nuevo
            while (actual != null && actual.dato.compareTo(dato) < 0) {
                actual = actual.siguiente;
            }

            // Enlazamos el nuevo nodo justo antes del nodo 'actual'
            nuevo.siguiente = actual;
            nuevo.anterior = actual.anterior;

            // Actualizamos los punteros de los nodos vecinos
            actual.anterior.siguiente = nuevo;
            actual.anterior = nuevo;
        }

        tamaño++; // Incrementamos el contador global de la clase padre
    }
}