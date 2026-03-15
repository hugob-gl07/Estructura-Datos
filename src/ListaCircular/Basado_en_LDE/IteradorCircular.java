package ListaCircular.Basado_en_LDE;
/**
 * Representa un iterador circular que recorre la lista exactamente una vuelta.
 * Usa un contador para evitar el bucle infinito propio de la estructura circular.
*/
public class IteradorCircular<T> implements MiIterador<T> {
    private ElementoDE<T> actual;
    private int elementosVisitados;
    private int total;
    /** Constructor con el nodo de inicio y el total de elementos.*/
    public IteradorCircular(ElementoDE<T> comienzo, int total) {
        this.actual = comienzo;         // Empezamos desde el nodo indicado
        this.total = total;             // Guardamos el total de elementos a recorrer
        this.elementosVisitados = 0;    // Inicializamos el contador de elementos visitados
    }
    /**
     * Comprueba si quedan elementos por recorrer.
     * Compara los elementos visitados con el total para no dar más de una vuelta.
     */
    @Override
    public boolean hasNext() {
        return elementosVisitados < total; // Si visitados es menor que total quedan elementos
    }
    /** Devuelve el elemento actual y avanza al siguiente.*/
    @Override
    public T next() {
        T valor = actual.dato;          // Guardamos el dato del elemento actual
        actual = actual.siguiente;      // Avanzamos al siguiente elemento
        elementosVisitados++;           // Incrementamos el contador de visitados
        return valor;                   // Devolvemos el dato guardado
    }
}