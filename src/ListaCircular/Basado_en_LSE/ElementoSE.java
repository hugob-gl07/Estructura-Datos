package ListaCircular.Basado_en_LSE;
/** Representa un nodo de una lista simplemente enlazada.*/
public class ElementoSE<T> {
    public T dato;                   // El dato que almacena el nodo
    public ElementoSE<T> siguiente;  // Puntero al siguiente nodo
    /**
     * Constructor con dato.
     * Inicializa siguiente a null ya que al crearse no apunta a ningún nodo.
     */
    public ElementoSE(T valor) {
        this.dato = valor;      // Guardamos el dato en el nodo
        this.siguiente = null;  // Al principio no hay siguiente elemento
    }
}