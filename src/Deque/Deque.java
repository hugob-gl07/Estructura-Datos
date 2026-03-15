package Deque;
import LDE.ElementoDE;
import LDE.LDEOrdenada;
/**
 * Representa una cola doble (Deque) que permite inserción y eliminación por ambos extremos.
 * Utiliza internamente una ListaDoblementeEnlazada ordenada.
 */
public class Deque<T extends Comparable<T>> {
    private LDEOrdenada<T> lista=new LDEOrdenada<>();
    /** Inserta un elemento al inicio del Deque.*/
    public void addFirst(T dato){
        lista.addFirst(dato);
    }
    /** Inserta un elemento al final del Deque. */
    public void addLast(T dato){
        lista.add(dato);
    }
    /** Elimina y devuelve el primer elemento del Deque.*/
    public T removeFirst(){
        return lista.removeFirst();
    }
    /** Elimina y devuelve el último elemento del Deque.*/
    public T removeLast(){
        return lista.removeLast();
    }
    /** Devuelve el primer elemento sin eliminarlo.*/
    public T peekFirst(){
        return lista.getFirst();
    }
    /** Devuelve el último elemento sin eliminarlo. */
    public T peekLast(){
        return lista.getLast();
    }
    /** Devuelve true si el Deque está vacío, false si no.*/
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    /** Devuelve el número de elementos del Deque. */
    public int size(){
        return lista.getSize();
    }
    /** Vacía el Deque eliminando todos sus elementos.*/
    public void clear(){
        lista.clear();
    }
    /** Comprueba si un elemento existe en el Deque.*/
    public boolean contains(T dato){
        return lista.get(dato)!=null;
    }
    /** Devuelve una representación en texto del Deque.*/
    @Override
    public String toString() {
        return lista.toString();
    }
}