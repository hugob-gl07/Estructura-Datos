package PILA.COLA.LISTACIRCULAR;

import Exceptions.ListaCircularExceptions;

/**
 * Representa una lista circular genérica.
 * El último elemento apunta de vuelta al primero formando un ciclo.
*/
public class ListaCircular<T extends Comparable<T>> {
    private Elemento<T> siguiente; // Puntero auxiliar al siguiente elemento
    private Elemento<T> cabeza;    // Puntero al primer elemento de la lista
    /** Inserta un dato al final de la lista circular.*/
    public void insertar(T dato){
        Elemento<T> nuevo= new Elemento<>(dato); // Creamos un nuevo elemento con el dato
        if(cabeza==null){
            // Si la lista está vacía el nuevo elemento apunta a sí mismo cerrando el ciclo
            cabeza=nuevo;
            nuevo.setSiguiente(nuevo);
        }
        else {
            Elemento<T> actual=cabeza; // Empezamos desde la cabeza
            while (actual.getSiguiente()!=cabeza){
                actual=actual.getSiguiente(); // Avanzamos hasta llegar al último elemento
            }
            actual.setSiguiente(nuevo);  // El último apunta al nuevo elemento
            nuevo.setSiguiente(cabeza);  // El nuevo apunta a la cabeza cerrando el ciclo
        }
    }
    /** Elimina y devuelve el primer dato de la lista circular.*/
    public T eliminar(){
        if(cabeza==null){
            throw  new ListaCircularExceptions("Error: La lista circular esta vacía, no podemos eliminar ni devolver el dato"); // Si la lista está vacía lanzamos el error
        }
        T dato=cabeza.getDato(); // Guardamos el dato de la cabeza para devolverlo
        if(cabeza.getSiguiente()==cabeza){
            // Si solo hay un elemento vaciamos la lista
            cabeza=null;
        }
        else {
            Elemento<T>nuevo=cabeza; // Empezamos desde la cabeza
            while (nuevo.getSiguiente()!=cabeza){
                nuevo=nuevo.getSiguiente(); // Avanzamos hasta llegar al último elemento
            }
            cabeza=cabeza.getSiguiente(); // El segundo elemento pasa a ser la nueva cabeza
            nuevo.setSiguiente(cabeza);   // El último apunta a la nueva cabeza cerrando el ciclo
        }
        return dato;
    }
}