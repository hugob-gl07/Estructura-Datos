package ListaCircular.Basado_en_LDE;
/**
 * Representa un nodo de una lista doblemente enlazada.
 * Reutilizado para la lista circular doblemente enlazada.
*/
public class ElementoDE<T> {
    T dato;
    ElementoDE<T> siguiente; // Puntero al siguiente nodo
    ElementoDE<T> anterior;  // Puntero al nodo anterior
    /**
     * Constructor con dato.
     * Inicializa siguiente y anterior a null.
     */
    public ElementoDE(T dato) {
        this.dato = dato;
        this.siguiente = null; // El nodo no apunta a ningún siguiente
        this.anterior = null;  // El nodo no apunta a ningún anterior
    }
}