package ListaCircular.Basado_en_LSE;
/**
 * Representa un iterador circular que recorre la lista simplemente enlazada exactamente una vuelta.
 * Usa un contador para evitar el bucle infinito propio de la estructura circular.
 */
public class IteradorCircularSE<T> implements MiIterador<T> {
    private ElementoSE<T> actual;  // Nodo actual del recorrido
    private int contador = 0;      // Contador de elementos visitados
    private int total;             // Total de elementos a recorrer
    /** Constructor con el nodo de inicio y el total de elementos.*/
    public IteradorCircularSE(ElementoSE<T> inicio, int total) {
        this.actual = inicio;  // Empezamos desde el nodo indicado
        this.total = total;    // Guardamos el total de elementos a recorrer
    }
    /**
     * Comprueba si quedan elementos por recorrer.
     * Compara el contador con el total para no dar más de una vuelta.
     */
    @Override
    public boolean hasNext() {
        return contador < total; // Si el contador es menor que el total quedan elementos
    }
    /** Devuelve el elemento actual y avanza al siguiente.*/
    @Override
    public T next() {
        T valor = actual.dato;         // Guardamos el dato del elemento actual
        actual = actual.siguiente;     // Avanzamos al siguiente elemento
        contador++;                    // Incrementamos el contador de visitados
        return valor;                  // Devolvemos el dato guardado
    }
}